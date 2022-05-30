package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {

	@FindBy(id="dtlview_Campaign Name")
	private WebElement CampaignInformation;
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String CampaignInfo() {
	return CampaignInformation.getText();
	}
	
	
}
