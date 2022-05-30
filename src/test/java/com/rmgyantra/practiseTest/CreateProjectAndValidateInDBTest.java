package com.rmgyantra.practiseTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectAndValidateInDBTest {
public static void main(String[] args) throws InterruptedException, SQLException, IOException {
	
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8084");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	driver.findElement(By.xpath("//span[.='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("project_102");
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("MohanGowda");
	
	WebElement projectstatusdropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s = new Select(projectstatusdropdown);
	s.selectByVisibleText("Completed");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	

	//step1: create object for implementation class 
	Driver driver1=new Driver();
	

	//step2: register the driver with JDBC
	DriverManager.registerDriver(driver1);
	
	//step3: establish the database connection
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3036/projects", "root", "root");
    

	//step4: create statements
	Statement statement = connection.createStatement(); 
	
	//step5: execute query
	ResultSet result = statement.executeQuery("select * from project;");
	
	//step6: validate
	while(result.next())
	{
		System.out.println(result.getString(1)+""+(result.getString(2)));
	}
	
	//step7: close the connection
	connection.close();
	
}
}
