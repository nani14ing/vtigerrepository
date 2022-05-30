package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContact;
	
    @FindBy(xpath="//img[@src='themes/images/findduplicates.gif']")
    private WebElement FindDuplicate;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createContact() {
		createContact.click();	
	}
	
	
	public void clickOnFindDuplicates() {
	FindDuplicate.click();
	}
	
}
