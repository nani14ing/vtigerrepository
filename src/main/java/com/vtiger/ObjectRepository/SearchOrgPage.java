package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class SearchOrgPage {

	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();


	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;		
	
	
	
	public SearchOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectOrganization(String OrgName, WebDriver driver) {
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Accounts&action");
		searchTxt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Contacts");
	}
	
}
