package com.vtiger.organisationTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.vtiger.ObjectRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganisationTest extends BaseClass {
	String organization_name;
	OrganizationPage OrgPage;
	CreateNewOrganizationPage createNewOrgPage;
	OrganizationInformationPage Org_info_page;
	//MSExcelLibrary msExcelLibrary;
	
	@Test
	public void createOrganisationByExcelAndPFTest() {
		
	organization_name = msExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1)+randomNumber;

	OrganizationPage OrgPage=new OrganizationPage(driver);
	CreateNewOrganizationPage createNewOrgPage=new CreateNewOrganizationPage(driver);
	OrganizationInformationPage Org_info_page= new OrganizationInformationPage(driver);
	
 	
	homepage.clickOnOrganization();
 	
	OrgPage.createOrganization();
			
	createNewOrgPage.enterOrganizationName(organization_name);
	
	createNewOrgPage.SaveOrg();
	
	Org_info_page.waitUntilOrganizatioNameVisible(driver);
	String createdOrganization = Org_info_page.OrganInfo();
	javautil.assertionThroughIfCondition(createdOrganization, createdOrganization, "ContactWithOrganizationTest created");
	
}
}
