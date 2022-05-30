package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class CreateNewOrganizationPage {

	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();

	
	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='accountname']")
	private WebElement OrganizationNameTxt;
	
	
	@FindBy(name=("industry"))
	private WebElement IndDropdown;
	

	@FindBy(name=("accounttype"))
	private WebElement AccDropdown;
	
	
	
	@FindBy(name=("button"))
	private WebElement SaveBtn;
	
	
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterOrganizationName(String organization_name) {
		OrganizationNameTxt.sendKeys(organization_name);	
	}
	
	public void industryDropdown(WebDriver driver, String visible) {
		webDriverLibrary.initializeDropDown(IndDropdown);
		webDriverLibrary.handleByVisibleText( visible );
		
	}
	
	public void accountsDropdown(WebDriver driver, String visible) {
		webDriverLibrary.initializeDropDown(AccDropdown);
		webDriverLibrary.handleByVisibleText( visible );
	}
	
	
	
	public void SaveOrg() {
		SaveBtn.click();
		
	}
	
}
