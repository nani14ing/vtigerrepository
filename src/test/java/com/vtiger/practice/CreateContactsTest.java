package com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {
	
public static void main(String[] args) throws InterruptedException {
	
	JavaLibrary javautil=new JavaLibrary();
	WebDriver driver=null;
	WebDriverLibrary webDriverLibrary;
	
	
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='lastname']")).sendKeys("ingalagii");
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	Thread.sleep(2000);
	
	 WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	 javautil.assertionThroughIfCondition(ele.getText(), "ingalagii", "");

	 
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 webDriverLibrary=new WebDriverLibrary();
	webDriverLibrary.mouseHoverOnTheElement(ele1, webDriverLibrary);
	
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	webDriverLibrary.quitBrowser(driver);
	
}
}


