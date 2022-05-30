package com.sdet34l1.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class is used to maintain all the webdriver common actions 
 * @author Admin
 *
 */
public class WebDriverLibrary {
	 WebDriverWait wait;
	 Select s;
	 public Actions act;
	 JavascriptExecutor js;
	 JavaLibrary javautil=new JavaLibrary();
	
	
	/**
	 * this method is used to navigate to the application
	 * @param url
	 */
	public void navigateApp(String url, WebDriver driver) {
		driver.get(url);
	}
	
	
	/**
	 * This method is used to maximize browser and to implicitly wait till the page load
	 * @param longtime
	 * @param driver
	 */
	public void browserSetting(long longTime, WebDriver driver) {
		maximizeBrowser(driver);
		waitTillPageLoad(longTime, driver);	
	}
	
	/**
	 * This method is used to implicitly wait till page load
	 * @param longTime
	 * @param driver
	 */
	public void waitTillPageLoad(long longTime, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longTime, TimeUnit.SECONDS);
	}
	
	
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	 public void maximizeBrowser(WebDriver driver) {
		 driver.manage().window().maximize();
	 }
	
	 
	 /**
	  * This method is used to initialize the action class
	  * @param driver
	  */
	 public void initializeActions(WebDriver driver) {
		 act=new Actions(driver);
	 }

	/**
	 * This method is used to mouse hover on the element
	 * @param moreLink
	 * @param driver
	 */
	public void mouseHoverOnTheElement(WebElement moreLink, WebDriverLibrary webDriverLibrary) {
		
	 	act.moveToElement(moreLink).perform();
	}

	/**
	 * this method is used to double click on the element
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		
		act.doubleClick(element);		
	}
	
	
	
	/**
	 * this method is used to initialize select class
	 * @param argument
	 */
	public void initializeDropDown(WebElement element) {
	  s = new Select(element);
	}
	
	/**
	 * this method is used to handle dropdown by visible text
	 * @param element 
	 * @param element
	 */
	public void handleByVisibleText( String visibleText) {
		s.selectByVisibleText(visibleText);
	}
	
	
	/**
	 * this method is used to handle dropdown by index
	 * @param elelment
	 * @param index
	 */
	public void handleByIndex(WebElement elelment, int index) {
		s.selectByIndex(index);
	}
	
	
    /**
     * this method is used to handle dropdown by value
     * @param value
     * @param elelment
     */
	public void handleByValue(String value,WebElement elelment) {
		s.selectByValue(value); 
	}
	
	
	
	/**
	 * this method is used to wait the control till the particular element is clickable
	 * @param element
	 */
	public void waitUntilElementClickable(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		

	/**
	 * this method is used to wait the control till the particular element is visible
	 * @param element
	 */
	public void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

		
	/**
	 * this method is used to initialize instance wait
	 * @param driver
	 * @param longTime
	 */	
	public void expclicitlyWait(WebDriver driver, long longTime) {
		 wait = new WebDriverWait(driver, longTime);		
	}
	
	
	/**
	 * This method is used to Switch the window based on the title
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindowBasedOnTitle(WebDriver driver, String partialText) {
	Set<String> sessionIDs = driver.getWindowHandles();	
	for(String id:sessionIDs)
	{
		driver.switchTo().window(id);
		if(driver.getTitle().contains(partialText))
		{
			break;
		}
	}
}
	
	/**
	 * this method is used to switch from webpage to frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method is used to switch from webpage to frame by using name Or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchtoFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * this method is used to the main frame
	 * @param driver
	 */
	public void switchBackToHome(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * This method is used to exit from the browser
	 * @param driver
	 */
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void initializeJs(WebDriver driver) {
		js=(JavascriptExecutor) driver;
	}
	
	
	public void enterDataThroughJs(WebElement element, String data) {
	js.executeScript("arguments[0].value=arguments[1]", element, data);	
	}
	
	
	public void clickThroughJs(WebElement element) {
		js.executeScript("arguments[0].clcik()", element);
	}
	
	
	public void navigateAppThroughJs(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	
	
	public void scrollToSpecificHeight(String height) {
		js.executeScript("arguments[0].scrollBy(0,"+height+")");
	}
	
	
	public void scrollToBottom() {
	js.executeScript("arguments[0].scrollBy(0, document.body.scrollHeight)");
	}
	
	
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	
	public String takeScreenShot(String fileName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./shreenshot/"+fileName+"_"+javautil.dateTimeInFormat()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
		    
	}
}
