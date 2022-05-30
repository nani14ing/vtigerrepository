package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropFileTest {
public static void main(String[] args) throws IOException {
	
	//step1:convert external files to java readable file
	FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.properties");
	
	//step2:create object for the property file
	Properties P = new Properties();
	
	//step3:load all the keys
	P.load(fis);
	
	//step4:fetch the data by using key
	String url = P.getProperty("url");
	String un = P.getProperty("UN");
	String pwd = P.getProperty("PWD");
	String lastname = P.getProperty("LN");
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
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
}
}
