package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;

import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.PropertyFileLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationinIndustryTest {
public static void main(String[] args) throws IOException, InterruptedException {
	
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
	//String camp_name = propertyFileLibrary.getdataFromPropertyFile("camp_name");
	String browser =propertyFileLibrary.getdataFromPropertyFile("Browser");
	String timeout = propertyFileLibrary.getdataFromPropertyFile("timeout");
	
	long longtime = javautil.stringToLong(timeout);	
	int randomNumber=javautil.getRandomNumber(1000);
	
	String organization_name = msExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1)+randomNumber;
	
	
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
	
	WebDriverLibrary webDriverLibrary = new WebDriverLibrary();
	
	webDriverLibrary.waitTillPageLoad(longtime, driver);
	webDriverLibrary.navigateApp(url, driver);
	webDriverLibrary.maximizeBrowser(driver);
	
	
   	    
 	//driver=new FirefoxDriver();
 	//driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
 	//driver.get(url);
 	
 	
 	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
 	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
 	driver.findElement(By.xpath("//input[@type='submit']")).click();
 	
 	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
 	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
 	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='accountname']")).sendKeys(organization_name);
 	
 	WebElement ele2 = driver.findElement(By.name("industry"));
	
 	webDriverLibrary.initializeDropDown(ele2); 	
 	webDriverLibrary.handleByVisibleText("Education");
 	
 /*
 	Select s = new Select(ele2);
 	Thread.sleep(2000);
 	s.selectByVisibleText("Education");
 */
 	
 	WebElement ele3 = driver.findElement(By.name("accounttype"));
	
 	webDriverLibrary.initializeDropDown(ele3); 	
 	webDriverLibrary.handleByVisibleText("Press");
 	
 
/*
 	 s = new Select(ele3);
 	s.selectByVisibleText("Press");
*/
 	
 	driver.findElement(By.name("button")).click();
 
 	
   //if conditon............
 	 WebElement finalOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
 	 javautil.assertionThroughIfCondition(finalOrgName.getText(), organization_name, "");
 	 
/* 	 
 	if(ele.contains("Q"))
 	{
 		javautil.printStatement("VALIDATED");
 	}
 	else
 	{
 		javautil.printStatement("NOT VALIDATED");
 	}
*/ 	
 	
 	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 	webDriverLibrary.mouseHoverOnTheElement(ele1, webDriverLibrary);
 	
    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
 	
    webDriverLibrary.quitBrowser(driver);
}
}
