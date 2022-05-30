package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDatafromPfTest {
public static void main(String[] args) throws IOException {
	JavaLibrary javautil=new JavaLibrary();
	
	FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.properties");
	Properties P = new Properties();
	P.load(fis);
	String url = P.getProperty("url");
	String un = P.getProperty("UN");
	String pwd = P.getProperty("PWD");
	String prod_name = P.getProperty("prod_name");
	String browser = P.getProperty("Browser");
	String timeout = P.getProperty("timeout");
	
	long longtime = Long.parseLong(timeout);
	WebDriver driver=null;
	
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
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prod_name);
	driver.findElement(By.xpath("//input[@name='button']")).click();
	
	WebElement product_name = driver.findElement(By.id("mouseArea_Product Name"));
 	javautil.assertionThroughIfCondition(product_name.getText(), prod_name, "");
 	
/* 	
 	if(product_name.contains("on"))
 	{
 		javautil.printStatement("product created");
 	}
 	else
 	{
 		javautil.printStatement("tc fail");
 	}
*/ 	
   	 
	WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	WebDriverLibrary.mouseHoverOnTheElement(ele2, driver);
	
 	driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
 	WebDriverLibrary.quitBrowser(driver);
	
}
}
