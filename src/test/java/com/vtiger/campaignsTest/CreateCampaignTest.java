package com.vtiger.campaignsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.vtiger.ObjectRepository.CampaignInformationPage;
import com.vtiger.ObjectRepository.CampaignPage;
import com.vtiger.ObjectRepository.CreateNewCampaignPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateCampaignTest extends BaseClass {
	
	String campaign_name;
	CampaignPage cp;
	CreateNewCampaignPage CnewCamp;
	CampaignInformationPage Camp_info_P;
	//MSExcelLibrary msExcelLibrary;
	
	
	@Test(groups="sanity", description="testng:-CreateCampaignTest")
	@Description("Description:-CreateCampaignTest")
	@Epic("Epic:-CreateCampaignTest")
	@Story("Story:-CreateCampaignTest")
	@Step("Step:-CreateCampaignTest")
	@Severity(SeverityLevel.BLOCKER)
	
	public void createCampaignByExcelAndPFTest() throws IOException {
		
		
		
	    campaign_name = msExcelLibrary.getDataFromExcel("CreateCampaignTest", 1, 1)+randomNumber;	    
	    CampaignPage cp=new CampaignPage(driver);
		CreateNewCampaignPage CnewCamp=new CreateNewCampaignPage(driver);
		CampaignInformationPage Camp_info_P=new CampaignInformationPage(driver);		
			
		homepage.clickCampaign(driver, webDriverLibrary);
		
		cp.CreateCampaign();
		
		CnewCamp.enterCampaignNameAndSave(campaign_name);	

		CnewCamp.saveCamp();

		javautil.assertionThroughIfCondition( Camp_info_P.CampaignInfo(), campaign_name, "campaign");		 	
}
}