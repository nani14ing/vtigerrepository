package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class OrganizationInformationPage {

	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Org_Information;
	
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String OrganInfo() {		
		return Org_Information.getText();
	}
	
	public void waitUntilOrganizatioNameVisible(WebDriver driver) {
		webDriverLibrary.expclicitlyWait(driver, 10);
		webDriverLibrary.waitUntilElementVisible(Org_Information);
	}
}
