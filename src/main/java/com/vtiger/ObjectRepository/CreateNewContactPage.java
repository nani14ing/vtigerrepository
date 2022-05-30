package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	
	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='lastname']")
	private WebElement contactName;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement SaveBtn;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUp;
	
	
	
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void enterContactName(String contact_name) {
		contactName.sendKeys(contact_name);
	}
	
	public void Orgnizationlookup() {
		orgLookUp.click();
	}
	
	public void clickSave() {
		SaveBtn.click();
	}
}
