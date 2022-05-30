package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class FetchDataFromPropFTest {
public static void main(String[] args) throws IOException {
	
	//to do auto-generated method stud
	JavaLibrary javautil=new JavaLibrary();
	WebDriver driver=null;
	
	PropertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	MSExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
	
	String url = PropertyFileLibrary.getdataFromPropertyFile("url");
	String un = PropertyFileLibrary.getdataFromPropertyFile("UN");
	String pwd = PropertyFileLibrary.getdataFromPropertyFile("PWD");
	//String camp_name = PropertyFileLibrary.getdataFromPropertyFile("camp_name");
	String browser =PropertyFileLibrary.getdataFromPropertyFile("Browser");
	String timeout = PropertyFileLibrary.getdataFromPropertyFile("timeout");
	
	long longtime = javautil.stringToLong(timeout);
	
	int randomNumber=javautil.getRandomNumber(1000);
	
	String Camp_name = MSExcelLibrary.getDataFromExcel("CreateCampaignTest", 1, 1)+randomNumber;


/*
	FileInputStream fisExcel=new FileInputStream("./src/test/resources/ex.xlsx");
	Workbook wb=WorkbookFactory.create(fisExcel);
	String Camp_name=wb.getSheet("CreateCampaignTest").getRow(1).getCell(1).getStringCellValue()+randomNumber;
*/	
	
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();

	default:
		break;
	}
	
	WebDriverLibrary.browserSetting(longtime, driver);
	WebDriverLibrary.navigateApp(url, driver);
	WebDriverLibrary.maximizeBrowser(driver);
	
/*	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
*/
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//mouseover action
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	WebDriverLibrary.mouseHoverOnTheElement(ele1, driver);

	driver.findElement(By.xpath("//a[@href='index.php?module=Campaigns&action=index']")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(Camp_name);
	driver.findElement(By.xpath("//input[@value='U']")).click();
	driver.findElement(By.xpath("//input[@type='submit'and @value=\"  Save  \"]")).click();
	
	ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	WebDriverLibrary.mouseHoverOnTheElement(ele1, driver);
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	
	WebDriverLibrary.quitBrowser(driver);
}
}


