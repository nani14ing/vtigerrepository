package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

//create the class as webpage name and make it as public
public class HomePage {
	
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	
	
//declare all the elements and specify the access specifier as private
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropdown;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement campaignTab;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationIcon;
	
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOutLink;
	
	
	@FindBy(xpath="//a[.='Contacts']")
     private WebElement ContactTab;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productTab;
	
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement OrganizationTab;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement clickOnDocument;
	
	@FindBy(xpath="//img[@title='Show World Clock...']")
	private WebElement showWorldClock;
	

	@FindBy(xpath="//select[@id='clockcity']")
	private WebElement cityDropDown;
	
	
	//initialize the driver address to all the elements through constructors and make it as public 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
		
	
	//business library........
	public void clickCampaign(WebDriver driver,  WebDriverLibrary webDriverLibrary) {
	    webDriverLibrary.mouseHoverOnTheElement(moreDropdown,webDriverLibrary);
		campaignTab.click();
	}
	
	public void signOut(WebDriver driver, WebDriverLibrary webDriverLibrary) {	
		webDriverLibrary.mouseHoverOnTheElement(administrationIcon,webDriverLibrary);
		signOutLink.click();
	}
	

	public void ClickOnContacts() {
		ContactTab.click();
	}
	
	public void clickOnProduct() {
		productTab.click();
	}
	
	public void clickOnOrganization() {
		OrganizationTab.click();
	}
	
	
	public void clickOnDocuments() {
		clickOnDocument.click();
	}
	
	public void ClickOnShowWorldClock() {
		showWorldClock.click();
	}
	
	public void clickOnCityDropDown(WebDriver driver, String value) {
		webDriverLibrary.initializeDropDown(cityDropDown);
		webDriverLibrary.handleByVisibleText(value);
	}
}
