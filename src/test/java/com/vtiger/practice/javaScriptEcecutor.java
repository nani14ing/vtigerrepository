package com.vtiger.practice;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptEcecutor {

	public static void main(String[] args) throws IOException {

		WebDriverLibrary webDriverLibrary = new WebDriverLibrary();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		webDriverLibrary.initializeJs(driver);
		driver.manage().window().maximize();

		
		
		webDriverLibrary.navigateAppThroughJs("http://localhost:8888");
		//js.executeScript("window.location='http://localhost:8888'");
		
		
		webDriverLibrary.enterDataThroughJs(driver.findElement(By.name("user_name")), "admin");
		//js.executeScript("arguments[0].value=argumnets[1]", driver.findElement(By.name("user_name")));
		

		webDriverLibrary.enterDataThroughJs(driver.findElement(By.name("user_password")), "admin");
		//js.executeScript("arguments[0].value=argumnets[1]", driver.findElement(By.name("user_password")));
		

		webDriverLibrary.clickThroughJs(driver.findElement(By.id("submitButton")));
		//js.executeScript("arguments[0].click()", driver.findElement(By.id("submitButton")));
		
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		webDriverLibrary.scrollTillElement(driver.findElement(By.xpath("//b[contains(.,' Upcoming Activities')]")));
		//js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//b[contains(.,' Upcoming Activities')]")));
		
		String fileName = new javaScriptEcecutor().getClass().getName();
		webDriverLibrary.takeScreenShot(fileName, driver);
		
 /*	
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
	    String fileName = new javaScriptEcecutor().getClass().getName();
	    String dateTime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date(0));
	    
	    File dst = new File("./shreenshot/"+fileName+"_"+dateTime+".png");
	    System.out.println(dst.getAbsolutePath());
	    FileUtils.copyFile(src, dst);
 */	    
	    		
		
	}
}
