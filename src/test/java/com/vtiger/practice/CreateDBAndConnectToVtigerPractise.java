package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDBAndConnectToVtigerPractise {
public static void main(String[] args) throws SQLException {
	Connection connection=null;
	String url1=null,Un1=null,pwd=null,fire=null,lastN=null,timeout1=null;
	long timeout2=0;
try
{
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet100", "root", "root");
	Statement statement = connection.createStatement();
	ResultSet result = statement.executeQuery("select * from vtiger");
	
	while(result.next())
	{
		 url1=result.getString("url");
		 Un1=result.getString("username");
		 pwd=result.getString("password");
		 fire=result.getString("browser");
		 lastN=result.getString("last_name");
	     timeout1=result.getString("timeout");
	     timeout2=Long.parseLong(timeout1);
	}
}
 finally
 {
	 connection.close();
 }
	WebDriver driver1=null;
	if(fire.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver1=new FirefoxDriver();
	}
	driver1.manage().timeouts().implicitlyWait(timeout2, TimeUnit.SECONDS);
	driver1.get(url1);
	driver1.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
	driver1.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	driver1.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver1.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver1.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver1.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastN);
	driver1.findElement(By.xpath("//input[@class='crmButton small save']")).click();

}
}
