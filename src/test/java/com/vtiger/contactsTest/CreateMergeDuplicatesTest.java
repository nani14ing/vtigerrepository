package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;
import com.vtiger.ObjectRepository.ContactMergeCriteriaPage;
import com.vtiger.ObjectRepository.ContactsPage;

public class CreateMergeDuplicatesTest extends BaseClass {
	ContactsPage contactpage;
	ContactMergeCriteriaPage cont_merge_cret_page;
	MSExcelLibrary msExcelLibrary;
	
	@Test
	public void createMergeDuplicatesTest93() throws InterruptedException {
		
   msExcelLibrary=new MSExcelLibrary();
	ContactsPage contactpage=new ContactsPage(driver);
	ContactMergeCriteriaPage cont_merge_cret_page= new ContactMergeCriteriaPage(driver);
	
	
	homepage.ClickOnContacts();
 	
	contactpage.clickOnFindDuplicates();
	
	cont_merge_cret_page.availableDropDown(driver, "Last Name");
	
	cont_merge_cret_page.addFieldsToMatch();
		
	cont_merge_cret_page.clickOnFindDuplicates();
	
	cont_merge_cret_page.clickOnCheckBox();
	
	cont_merge_cret_page.clickOnMergeBtn();

	webDriverLibrary.switchToWindowBasedOnTitle(driver, "ProcessDuplicates&mergemode");
	
	cont_merge_cret_page.clickOnMergeBtn();
	
}
}
