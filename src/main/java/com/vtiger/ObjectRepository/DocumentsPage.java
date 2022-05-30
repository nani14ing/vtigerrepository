package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage 
{
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createDocumentIcon;
	
	public DocumentsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createDocumentIcon()
	{
		createDocumentIcon.click();
	}
	
}
