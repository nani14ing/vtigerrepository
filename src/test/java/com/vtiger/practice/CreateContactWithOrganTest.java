package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateContactWithOrganTest {
public static void main(String[] args) throws IOException {
	
    //to do auto-generated method stud
		JavaLibrary javautil=new JavaLibrary();
		WebDriver driver=null;
		
		PropertyFileLibrary propertyFileLibrary = new PropertyFileLibrary();
		propertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		
		MSExcelLibrary msExcelLibrary = new MSExcelLibrary();
		msExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
		
		String url = propertyFileLibrary.getdataFromPropertyFile("url");
		String un = propertyFileLibrary.getdataFromPropertyFile("UN");
		String pwd = propertyFileLibrary.getdataFromPropertyFile("PWD");
		String browser =propertyFileLibrary.getdataFromPropertyFile("Browser");
		String timeout = propertyFileLibrary.getdataFromPropertyFile("timeout");
		
		long longtime = javautil.stringToLong(timeout);		
		int randomNumber=javautil.getRandomNumber(1000);
		
		String Contact_name = msExcelLibrary.getDataFromExcel("CreateContactTest", 1, 1)+randomNumber;
		
		String organization_name = msExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1)+randomNumber;
		
		
		
		/*FileInputStream fisExcel=new FileInputStream("./src/test/resources/ex.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		String Contact_name=wb.getSheet("CreateContactTest").getRow(1).getCell(1).getStringCellValue()+randomNumber;*/


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
	driver=new ChromeDriver();
	break;
}

WebDriverLibrary webDriverLibrary = new WebDriverLibrary();

webDriverLibrary.navigateApp(url, driver);
webDriverLibrary.browserSetting(longtime, driver);
webDriverLibrary.maximizeBrowser(driver);
		   
		    // creating organization................
		   
		   	WebDriverManager.firefoxdriver().setup();
		 	driver=new FirefoxDriver();
		 	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
		 	driver.get(url);
		 	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
		 	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		 	driver.findElement(By.xpath("//input[@type='submit']")).click();
		 	
		 	driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='accountname']")).sendKeys(organization_name);
		 	driver.findElement(By.name("button")).click();
		 	
		 // String final_org = driver1.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		 // System.out.println(final_org);
		  
		 /* if(final_org.contains(org_name))
		  {
			  System.out.println(org_name);
		  }
		  else
		  {
			  System.out.println("not present");
		  }*/
		  
		    //creating contact in organization..............k
		  
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='lastname']")).sendKeys(Contact_name);
			
			String parent_browser = driver.getWindowHandle();
			System.out.println(parent_browser);

			driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();//click on org button.
			Set<String> childAndparent = driver.getWindowHandles();//to fetch both child and parent
			int child = childAndparent.size();//to get count of address
			System.out.println(child);//count of child id
			
			childAndparent.remove(parent_browser);//remove the parent id
			
			for(String org_window:childAndparent)
		    driver.switchTo().window(org_window);//use to switch the control from parent to child
			
			//String child_browser = driver1.getTitle();
			//System.out.println(child_browser);
			
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(organization_name);
			driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
			driver.findElement(By.id("1")).click();
			
			driver.switchTo().window(parent_browser);//control switch back to parent id
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Contact_name);
			driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
			String final_contact = driver.findElement(By.id("dtlview_Last Name")).getText();
			
			if(final_contact.contains(Contact_name))
			{
				System.out.println("contact validated");
			}
			else
			{
				System.out.println("not validated");
			}
			WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(ele1).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			driver.quit();
			
			
			
			
			
			
			
		 	
		 	
		 	
		 	
}
}
