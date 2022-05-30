package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {

	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignName;
	
	@FindBy(xpath="//input[@type='submit'and @value=\"  Save  \"]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement ProductLookUp;
	

	//initialize the driver address to all the elements through constructors and make it as public 
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	
	public void enterCampaignNameAndSave(String campaign_name) {
		CampaignName.sendKeys(campaign_name);	
	}
	
	public void saveCamp() {
		SaveBtn.click();
	}
	
	public void enterCampaignNameAndSwitchToSearchProduct(String campaign_name, WebDriver driver) {
		CampaignName.sendKeys(campaign_name);
		ProductLookUp.click();
	}
}
