package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement EnterProdName;
	
	@FindBy(xpath="//input[@name='button']")
	private WebElement SaveBtn;
	
	
	
	
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void ProductName(String ProductName) {
		EnterProdName.sendKeys(ProductName);
	}
	
	public void saveProd() {
		SaveBtn.click();
	}
	
	
	
}
