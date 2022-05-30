package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.CreateNewContactPage;

public class CreateContactsTest  extends BaseClass{
	String Contact_name;
	ContactsPage Cont_P;
	CreateNewContactPage c_new_Cont;
	ContactInformationPage cont_info;
	//MSExcelLibrary msExcelLibrary;
	
	@Test
	public void createContactByExcelAndPFTest() {
		
	    Contact_name = msExcelLibrary.getDataFromExcel("CreateContactTest", 1, 1)+randomNumber;
	    
		ContactsPage Cont_P= new ContactsPage(driver);
		CreateNewContactPage c_new_Cont=new CreateNewContactPage(driver);
		ContactInformationPage cont_info=new ContactInformationPage(driver);			
	
	homepage.ClickOnContacts();
	
	Cont_P.createContact();
	
	c_new_Cont.enterContactName(Contact_name);
	
	c_new_Cont.clickSave();	

	javautil.assertionThroughIfCondition( cont_info.contactInfo(),  Contact_name, "contact created");
		
}
}
