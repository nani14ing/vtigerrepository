package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateContactsPage {

	@FindBy(xpath="//input[@name='CheckAll']")
	private WebElement selectDuplicates;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement duplicateContact;
	
	
	public DuplicateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectAllDuplicates() {
		selectDuplicates.click();
	}
	
	
	public void deleteDuplicateContact() {
		duplicateContact.click();
	}
	
	
}
