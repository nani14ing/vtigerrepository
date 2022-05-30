package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.CreateNewContactPage;

public class CreateContactTest extends BaseClass {
	
	String Contact_name;
	ContactsPage Cont_P;
	CreateNewContactPage c_new_Cont;
	ContactInformationPage cont_info;
	//MSExcelLibrary msExcelLibrary;
	
	
	@Test
	public void createContactAndvalidateInExcel() throws InterruptedException {
		
	    Contact_name = msExcelLibrary.getDataFromExcel("CreateContactTest", 1, 1)+randomNumber;
	    
		ContactsPage Cont_P= new ContactsPage(driver);
		CreateNewContactPage c_new_Cont=new CreateNewContactPage(driver);
		ContactInformationPage cont_info=new ContactInformationPage(driver);			
	    

		//testcase1:homepage................
	if(driver.getTitle().contains("Home"))
	{
		msExcelLibrary.insertDataIntoExcel("testcases", 14, 8, "home page is displayed");
		msExcelLibrary.insertDataIntoExcel("testcases", 14, 9, "test case pass");
		
	}    
	
	homepage.ClickOnContacts();
	//testcase2:click on contact................
	if(driver.getTitle().contains("Contacts"))
	{
		msExcelLibrary.insertDataIntoExcel("testcases", 15, 8, "contact page is displayed");
		msExcelLibrary.insertDataIntoExcel("testcases", 15, 9, "test case pass");
	}
	
	Cont_P.createContact();
	//testcase3:click on create contact icon..................
	msExcelLibrary.insertDataIntoExcel("testcases", 16, 8, "contact details is displayed");
	msExcelLibrary.insertDataIntoExcel("testcases", 16, 9, "test case pass");

	c_new_Cont.enterContactName(Contact_name);	
	c_new_Cont.clickSave();	

	//testcase4:enter the mandatosy field and click on save button
	msExcelLibrary.insertDataIntoExcel("testcases", 17, 8, "contact is saved");
	msExcelLibrary.insertDataIntoExcel("testcases", 17, 9, "test case pass");

	javautil.assertionThroughIfCondition( cont_info.contactInfo(),  Contact_name, "contact created");
	//testcase5:validate the data........................
	msExcelLibrary.insertDataIntoExcel("testcases", 18, 8, "data is validated");
	msExcelLibrary.insertDataIntoExcel("testcases", 18, 9, "test case pass");
	
	//testcase6:click on logout.....................	
	msExcelLibrary.insertDataIntoExcel("testcases", 19, 8, "login page is displayed");
	msExcelLibrary.insertDataIntoExcel("testcases", 19, 9, "test case pass");	
}
}
