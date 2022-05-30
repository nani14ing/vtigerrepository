package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.MSExcelLibrary;


public class TestNGPractice1Test{
	

	@Test(dataProvider = "multipledata1")
	public void practice1Test(String username, String password)
	{
		Reporter.log(username+"   ----->   "+password,true);
	}
	
	@DataProvider
	public Object[][] multipledata1() throws EncryptedDocumentException, IOException{
		MSExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
		return MSExcelLibrary.getMultipleDataFromEcxcel("multipledata");
	}
	
}
