package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.PropertyFileLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationAndValidateTcTest {
public static void main(String[] args) throws IOException, InterruptedException {
	
	//property file................
	
	PropertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	MSExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
	
	String url = PropertyFileLibrary.getdataFromPropertyFile("url");
	String un = PropertyFileLibrary.getdataFromPropertyFile("UN");
	String pwd = PropertyFileLibrary.getdataFromPropertyFile("PWD");
	String browser = PropertyFileLibrary.getdataFromPropertyFile("Browser");
	String timeout = PropertyFileLibrary.getdataFromPropertyFile("timeout");
	
	JavaLibrary javautil=new JavaLibrary();
	long time = javautil.stringToLong(timeout);
	
	String organization_name = MSExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1);
	
	WebDriver driver=null;
	
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;

	default:
		driver=new FirefoxDriver();
		break;
	}

	//testcase1:login to application...
	WebDriverLibrary.navigateApp(url, driver);
	WebDriverLibrary.browserSetting(time, driver);
	WebDriverLibrary.maximizeBrowser(driver);
	
 	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
 	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
 	driver.findElement(By.xpath("//input[@type='submit']")).click();
 	

	if(driver.getTitle().contains("Home"))
	{
 	
 	      MSExcelLibrary.insertDataIntoExcel("testcases", 27, 8, "home page is displayed");
		//wb.getSheet("testcases").getRow(27).createCell(8).setCellValue("home page is displayed");
		//wb.getSheet("testcases").getRow(27).createCell(9).setCellValue("test case pass");	
	}
	//FileOutputStream fos = new FileOutputStream("./src/test/resources/ex.xlsx");
	//wb.write(fos);
	//wb.close();
	
	
 	
	//testcase2:click on organization....

 	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
 	
 	if(driver.getTitle().contains("Accounts&action"))
	{
 	MSExcelLibrary.insertDataIntoExcel("testcases", 28, 8, "organization page is displayed");
 	MSExcelLibrary.insertDataIntoExcel("testcases", 28, 9, "test case pass");
	} 
	//wb.close();
	
	
 	//testcase3:click on create organization...
 	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
 	
	//wb.getSheet("testcases").getRow(29).createCell(8).setCellValue("organization deatils page is displayed");
	//wb.getSheet("testcases").getRow(29).createCell(9).setCellValue("test case pass");
	 //fos = new FileOutputStream("./src/test/resources/ex.xlsx");
	//wb.write(fos);
	
 	
 	//testcase4 and 5:enter the mandatory field and click on save button...
 	
 	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='accountname']")).sendKeys(organization_name);
	driver.findElement(By.name("button")).click();
	String ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
   // if(ele.contains("ss"))
       {
 		//wb.getSheet("testcases").getRow(30).createCell(8).setCellValue("organization is saved");
 		//wb.getSheet("testcases").getRow(30).createCell(9).setCellValue("test case pass");
 		
 		//wb.getSheet("testcases").getRow(31).createCell(8).setCellValue("organization is validated");
 		//wb.getSheet("testcases").getRow(31).createCell(9).setCellValue("test case pass");
 		// fos = new FileOutputStream("./src/test/resources/ex.xlsx");
 		//wb.write(fos);	
 		//wb.close();
       }
       
       MSExcelLibrary.writeDataIntoExcel(IconstantPath.EXCELFILEPATH);
       MSExcelLibrary.closeExcelFile();
	
	//testcase6:click on logout.....................
	
	Thread.sleep(2000);
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	WebDriverLibrary.mouseHoverOnTheElement(ele1, driver);
	//Actions act=new Actions(driver);	
	//act.moveToElement(ele1).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	//wb.getSheet("testcases").getRow(32).createCell(8).setCellValue("login page is displayed");
	//wb.getSheet("testcases").getRow(32).createCell(9).setCellValue("test case pass");	
	// fos = new FileOutputStream("./src/test/resources/ex.xlsx");
	//wb.write(fos);
	//wb.close();
	
	
}
}
