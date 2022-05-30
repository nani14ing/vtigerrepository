package com.vtiger.productsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.vtiger.ObjectRepository.CreateNewProductPage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductPage;

public class CreateProductTest extends BaseClass{
	String product_name;
	ProductPage Pg;
	CreateNewProductPage NewProd;
	ProductInformationPage Prod_info;
	//MSExcelLibrary msExcelLibrary;
		
	@Test
	public void createProductByExcelAndPfTest() {
		
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
