package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.CreateNewContactPage;
import com.vtiger.ObjectRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;
import com.vtiger.ObjectRepository.SearchOrgPage;

public class CreateContactWithOrganizationTest extends BaseClass {
	public String org_name;
	public String cont_name;
	ContactsPage Cont_P;
	CreateNewContactPage c_new_Cont;
	ContactInformationPage cont_info;
	OrganizationPage OrgPage;
	CreateNewOrganizationPage createNewOrgPage;
	OrganizationInformationPage Org_info_page;
	SearchOrgPage SearchOrg;
	//MSExcelLibrary msExcelLibrary;
	
	
@Test(groups="sanity")
public void createContactWithOrganTest() throws InterruptedException {
	
	org_name = msExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1)+randomNumber;
	cont_name = msExcelLibrary.getDataFromExcel("CreateContactTest", 1, 1)+randomNumber;
	
	OrganizationPage OrgPage=new OrganizationPage(driver);
	CreateNewOrganizationPage createNewOrgPage=new CreateNewOrganizationPage(driver);
	OrganizationInformationPage Org_info_page= new OrganizationInformationPage(driver);
	
	ContactsPage Cont_P= new ContactsPage(driver);
	CreateNewContactPage c_new_Cont=new CreateNewContactPage(driver);
	ContactInformationPage cont_info=new ContactInformationPage(driver);
	SearchOrgPage SearchOrg=new SearchOrgPage(driver);
	   
	
	homepage.clickOnOrganization();
	
	OrgPage.createOrganization();
	
	createNewOrgPage.enterOrganizationName(org_name);
	
	createNewOrgPage.SaveOrg();	
	Org_info_page.waitUntilOrganizatioNameVisible(driver);
	String createdOrganization = Org_info_page.OrganInfo();
	javautil.assertionThroughIfCondition(createdOrganization, createdOrganization, "CreateContactWithOrganizationTest");
	
	homepage.ClickOnContacts();
	
	Cont_P.createContact();
	
	c_new_Cont.enterContactName(cont_name);
	
	c_new_Cont.Orgnizationlookup();
	
	SearchOrg.selectOrganization(org_name, driver);
	
	c_new_Cont.clickSave();
	
	javautil.assertionThroughIfCondition(cont_info.contactInfo(), cont_name, "cont with org");
		 	
}
}
