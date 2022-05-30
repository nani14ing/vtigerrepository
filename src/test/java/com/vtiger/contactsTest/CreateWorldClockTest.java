package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;

public class CreateWorldClockTest extends BaseClass {

	@Test 
	public void createWorldClockTest91() {
		
		homepage.ClickOnShowWorldClock();
		
		homepage.clickOnCityDropDown(driver, "India");	 	
	}
}
