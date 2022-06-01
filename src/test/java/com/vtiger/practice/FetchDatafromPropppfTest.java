package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;
import com.vtiger.ObjectRepository.CreateNewProductPage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDatafromPropppfTest extends BaseClass {
	String product_name;
	ProductPage Pg;
	CreateNewProductPage NewProd;
	ProductInformationPage Prod_info;
	MSExcelLibrary msExcelLibrary;
	
	@Test
	public void fetchDatafromPfTest() {

	product_name = msExcelLibrary.getDataFromExcel("CreateProductTest", 1, 1)+randomNumber;
	ProductPage Pg= new ProductPage(driver);
	CreateNewProductPage NewProd= new CreateNewProductPage(driver);
	ProductInformationPage Prod_info=new ProductInformationPage(driver);
		
 	homepage.clickOnProduct();
 	
 	Pg.createProduct();
 	
 	NewProd.ProductName(product_name);
 	
 	NewProd.saveProd();
 		
 	javautil.assertionThroughIfCondition(Prod_info.ProductInformation(), product_name, "");	
}
}
