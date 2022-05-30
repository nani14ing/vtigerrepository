package com.vtiger.campaignsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.vtiger.ObjectRepository.CampaignInformationPage;
import com.vtiger.ObjectRepository.CampaignPage;
import com.vtiger.ObjectRepository.CreateNewCampaignPage;
import com.vtiger.ObjectRepository.CreateNewProductPage;
import com.vtiger.ObjectRepository.ProductPage;
import com.vtiger.ObjectRepository.SearchProductPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateCampaignWithProductTest extends BaseClass {

	String campaign_name;
	String product_name;
	CampaignPage cp;
	CreateNewCampaignPage CnewCamp;
	CampaignInformationPage Camp_info_P;

	
	@Test(groups="sanity", description="testng:-CreateCampaignWithProductTest")
	@Description("Description:-CreateCampaignWithProductTest")
	@Epic("Epic:-CreateCampaignWithProductTest")
	@Story("Story:-CreateCampaignWithProductTest")
	@Step("Step:-CreateCampaignWithProductTest")
	@Severity(SeverityLevel.BLOCKER)
	
	public void createCampaignWithProductTest() throws IOException, InterruptedException {
		
		
	product_name = msExcelLibrary.getDataFromExcel("CreateProductTest", 1, 1)+randomNumber;
	campaign_name = msExcelLibrary.getDataFromExcel("CreateCampaignTest", 1, 1)+randomNumber;
	ProductPage productPage=new ProductPage(driver);
	CreateNewProductPage createNewProduct=new CreateNewProductPage(driver);
	
	CampaignPage campaignPage=new CampaignPage(driver);
	CreateNewCampaignPage CreatenewCamp=new CreateNewCampaignPage(driver);
	CampaignInformationPage CampInfoPage=new CampaignInformationPage(driver);
	SearchProductPage searchProdpage=new SearchProductPage(driver);
						
//creating product..........................			
			homepage.clickOnProduct();
			
			productPage.createProduct();
			
			createNewProduct.ProductName(product_name);
		 	
			createNewProduct.saveProd();
		 			 	 	
		 	homepage.clickCampaign(driver, webDriverLibrary);
		 	
		 	campaignPage.CreateCampaign();	 	
		 	
		 	CreatenewCamp.enterCampaignNameAndSave(campaign_name);
		 	
		 	CreatenewCamp.enterCampaignNameAndSwitchToSearchProduct(campaign_name, driver);
		 	
		 	searchProdpage.selectProduct(product_name, driver);
		 			 	
		 		 	
		 	CreatenewCamp.saveCamp();
				
		 	javautil.assertionThroughIfCondition(CampInfoPage.CampaignInfo(), campaign_name, "campaign with product");
		 				 			 	
		 	
}
}
