package com.rmgyantra.practiseTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericlibrary.DataBaseLibrary;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.PropertyFileLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInDBAndValidateInRmgTest {
public static void main(String[] args) throws SQLException, InterruptedException, IOException {
	
	
	MSExcelLibrary msExcelLibrary=new MSExcelLibrary();
	JavaLibrary javautil=new JavaLibrary();
	PropertyFileLibrary propertyFileLibrary=new PropertyFileLibrary();
	DataBaseLibrary dataBaseLibrary=new DataBaseLibrary();
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	
	propertyFileLibrary.openPropertyFile(IconstantPath.RMG_YANTRA_PROPERTYFILE_PATH);
	msExcelLibrary.openExcelFile(IconstantPath.RMG_YANTRA_EXCELFILE_PATH);
	int randomNumber = javautil.getRandomNumber(1000);
	String project_name=msExcelLibrary.getDataFromExcel("projects", 1, 1)+"_"+randomNumber;
	System.out.println(project_name);
	dataBaseLibrary.openDBConnection(IconstantPath.DATABASEURL+propertyFileLibrary.getdataFromPropertyFile("dBName"), propertyFileLibrary.getdataFromPropertyFile("dBUserName"), propertyFileLibrary.getdataFromPropertyFile("dBPassWord"));
	dataBaseLibrary.setdataInDataBase("insert into project values('TY_PROJ_010+"+randomNumber+"', 'Narayan110', '09/05/2022', '"+project_name+"','Created','2');");
	dataBaseLibrary.closeDBConnection();
	
	
	/*
	        //step1: create object for implementation class 
			Driver driver=new Driver();
			
			//step2: register the driver with JDBC
			DriverManager.registerDriver(driver);
			
			//step3: establish the database connection
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		    
			//step4: create statements
			Statement statement = connection.createStatement();
			
			//step5: execute query
			int result = statement.executeUpdate("insert into project values('TY_PROJ_010','Narayan110','09/05/2022','project_110','Created','2');");
			if(result==1)
			{
				System.out.println("project added in database");
			}
			else {
				System.out.println("project not added in database");
			}
			connection.close();			
*/			
		   String text=null;
	       WebDriverManager.chromedriver().setup();
	       WebDriver driver=new ChromeDriver();
	       webDriverLibrary.browserSetting(randomNumber, driver);
	       webDriverLibrary.navigateApp("http://localhost:8084", driver);
	       
			driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			
			List<WebElement> listOfProjects = driver.findElements(By.xpath("//td[2]"));
			 
			 for(WebElement text1:listOfProjects)
			 {
				 
			 if(text1.getText().equalsIgnoreCase(project_name))
					 {
				 System.out.println("project name is visible in GUI");
				 System.out.println("TC pass");
				 break;
					 }
			 webDriverLibrary.quitBrowser(driver);
			 
}
}
					 
}
