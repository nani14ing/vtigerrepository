package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.vtiger.ObjectRepository.ContactMergeCriteriaPage;
import com.vtiger.ObjectRepository.ContactsPage;

public class CreateFindDuplicatesTest extends BaseClass {
	ContactsPage contactpage;
	ContactMergeCriteriaPage cont_merge_cret_page;
	
	@Test
	public void createFindDuplicatesTest91() {
		
		ContactsPage contactpage=new ContactsPage(driver);
		ContactMergeCriteriaPage cont_merge_cret_page= new ContactMergeCriteriaPage(driver);
		
		homepage.ClickOnContacts();
		
		contactpage.clickOnFindDuplicates();
	 		
		cont_merge_cret_page.availableDropDown(driver, "Last Name");
		
		cont_merge_cret_page.addFieldsToMatch();
		
		cont_merge_cret_page.clickOnFindDuplicates();
}
}
