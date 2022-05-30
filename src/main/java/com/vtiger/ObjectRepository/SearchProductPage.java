package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class SearchProductPage {
	
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;		
	
	
	
	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectProduct(String productName, WebDriver driver) {
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Products&action");
		searchTxt.sendKeys(productName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Campaigns");
	}
	
	
	
}
