package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.properties");
	Properties P = new Properties();
	P.load(fis);
	String url = P.getProperty("url");
	String un = P.getProperty("UN");
	String pwd = P.getProperty("PWD");
	String browser = P.getProperty("Browser");
	String timeout = P.getProperty("timeout");
	System.out.println(timeout);
	
	long longtime = Long.parseLong(timeout);
	WebDriver driver=null;
	//step1:convert physical file to java readable object
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ex.xlsx");


	    //step2:get excel 
	    Workbook wb = WorkbookFactory.create(fis1);
	    
	    //step3:get sheet
	    Sheet sh = wb.getSheet("Documents");
	    
	    //step4: get row
	    Row rw = sh.getRow(4);
	    
	    //step5: get cell
	    Cell cell = rw.getCell(1);
	    
	    Random ran=new Random();
	    int rand_num = ran.nextInt(10000);
	    
	    //step6:fetch data from cell
	    String doc_title = cell.getStringCellValue()+rand_num;
	   	    System.out.println(doc_title);
	    //step7:
	   // wb.close();
	
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
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	}

 	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
 	driver.get(url);
 	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
 	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
 	driver.findElement(By.xpath("//input[@type='submit']")).click();
 	
 	driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
 	driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
 	driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(doc_title);
 	driver.switchTo().frame(0);
    driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("Scripts", Keys.CONTROL+"a");
    
    driver.switchTo().defaultContent();  
    driver.findElement(By.xpath("//a[@id='cke_5']")).click();
    driver.findElement(By.xpath("//a[@id='cke_6']")).click();
    driver.findElement(By.id("filename_I__")).sendKeys("C://Users//Admin//Desktop//scripts.txt");
    driver.findElement(By.xpath("//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")).click();
    
    Thread.sleep(2000);
   	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   	Actions act=new Actions(driver);
   	act.moveToElement(ele1).perform();
   	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
   	
   	driver.quit();
}
}
