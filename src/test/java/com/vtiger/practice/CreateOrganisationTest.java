package com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver.findElement(By.xpath("//a[.='Organizations']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='accountname']")).sendKeys("TestYantra");
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	String ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(ele.contains("Test"))
	{
		System.out.println("VALIDATED");
	}
	else
	{
		System.out.println("NOT VALIDATED");
	}
	Thread.sleep(2000);
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele1).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
}
}
