package com.vtiger.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class ContactMergeCriteriaPage {
	
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();

	
	@FindBy(xpath="//select[@id='availList']")
	private WebElement availableFields;
	
	@FindBy(xpath="//input[@onclick='addColumn()']")
    private WebElement Addfields;
	
	
	@FindBy(xpath="//input[@value='Find Duplicates']")
	private WebElement FindDuplicate;
	
	
	@FindBy(xpath="//input[@name='group0']")
	private List<WebElement> checkboxes;
	
	@FindBy(xpath="//input[@name='merge']")
	private WebElement clickOnMerge;
	
	
	
	public ContactMergeCriteriaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void availableDropDown(WebDriver driver, String value)
	{
		webDriverLibrary.initializeDropDown(availableFields);
		webDriverLibrary.handleByVisibleText(value);
	}
	
	public void addFieldsToMatch() {
		Addfields.click();
	}
	
	
	public void clickOnFindDuplicates() {
		FindDuplicate.click();
	}
	
	
	public void clickOnMergeBtn() {
		clickOnMerge.click();
	}
	
	public void clickOnCheckBox() {
		for(WebElement we:checkboxes)
		{
		we.click();
		}
		
	}
}
