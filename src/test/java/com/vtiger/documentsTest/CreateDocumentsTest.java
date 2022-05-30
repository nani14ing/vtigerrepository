package com.vtiger.documentsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.PropertyFileLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;
import com.vtiger.ObjectRepository.CreateNewDocumentsPage;
import com.vtiger.ObjectRepository.DocumentsPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentsTest extends BaseClass {
	
	String Doc_title;
	String Doc_path;
	String Doc_desc;
	DocumentsPage doc_page;
	CreateNewDocumentsPage createNewDocPage;
	//MSExcelLibrary msExcelLibrary;
	//WebDriverLibrary webDriverLibrary;
	
	@Test 
	public void createDocumentsTest() throws InterruptedException {	
		
		
	 Doc_title = msExcelLibrary.getDataFromExcel("Documents", 4, 1)+randomNumber;
	 Doc_path = msExcelLibrary.getDataFromExcel("Documents", 4, 2);
	 Doc_desc = msExcelLibrary.getDataFromExcel("Documents", 4, 3)+randomNumber;	
	 DocumentsPage doc_page=new DocumentsPage(driver);
	 CreateNewDocumentsPage createNewDocPage=new CreateNewDocumentsPage(driver) ;
	
	 homepage.clickOnDocuments();
	
 	 doc_page.createDocumentIcon();
 
 	 createNewDocPage.documentTitle(driver, Doc_title);
 		 
	 createNewDocPage.descriptionArea(driver,Doc_desc);
	 
	 webDriverLibrary.switchBackToHome(driver); 
        
     createNewDocPage.boldAndItalic();
     
     createNewDocPage.chooseFileBtn(Doc_path);
     
     createNewDocPage.saveDocuments(); 
}
}
