package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaLibrary;
import com.sdet34l1.genericlibrary.MSExcelLibrary;
import com.sdet34l1.genericlibrary.PropertyFileLibrary;
import com.sdet34l1.genericlibrary.WebDriverLibrary;
import com.vtiger.ObjectRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationByExcelAndPFTest {
public static void main(String[] args) throws IOException, InterruptedException {
	

	  //to do auto-generated method stud
			JavaLibrary javautil=new JavaLibrary();
			WebDriver driver=null;
			
			PropertyFileLibrary propertyFileLibrary = new PropertyFileLibrary();
			propertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
			
			MSExcelLibrary msExcelLibrary = new MSExcelLibrary();
			msExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
			
			String url = propertyFileLibrary.getdataFromPropertyFile("url");
			String un = propertyFileLibrary.getdataFromPropertyFile("UN");
			String pwd = propertyFileLibrary.getdataFromPropertyFile("PWD");
			String browser =propertyFileLibrary.getdataFromPropertyFile("Browser");
			String timeout = propertyFileLibrary.getdataFromPropertyFile("timeout");
			
			long longtime = javautil.stringToLong(timeout);
			
			int randomNumber=javautil.getRandomNumber(1000);
			
			String organization_name = msExcelLibrary.getDataFromExcel("CreateOrganizationTest", 1, 1)+randomNumber;
					
           /*
			FileInputStream fisExcel=new FileInputStream("./src/test/resources/ex.xlsx");
			Workbook wb=WorkbookFactory.create(fisExcel);
			String organization_name=wb.getSheet("CreateOrganizationTest").getRow(1).getCell(1).getStringCellValue()+randomNumber;
			wb.close();
			*/
			
	
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;

	default:
		break;
	}
	
	WebDriverLibrary webDriverLibrary = new WebDriverLibrary();
	
	webDriverLibrary.browserSetting(longtime, driver);
	webDriverLibrary.navigateApp(url, driver);
	webDriverLibrary.maximizeBrowser(driver);
	
	LoginPage loginPage=new LoginPage(driver);
	HomePage homePage=new HomePage(driver);
	OrganizationPage OrgPage=new OrganizationPage(driver);
	CreateNewOrganizationPage createNewOrgPage=new CreateNewOrganizationPage(driver);
	OrganizationInformationPage Org_info_page= new OrganizationInformationPage(driver);
	
	/*
 	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
 	driver.get(url);
 	*/
	loginPage.loginAction(un, pwd);
 //driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
 //driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
 //driver.findElement(By.xpath("//input[@type='submit']")).click();
 	
	homePage.clickOnOrganization();
//driver.findElement(By.xpath("//a[.='Organizations']")).click();
 	
	OrgPage.createOrganization();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
		
	createNewOrgPage.enterOrganizationName(organization_name);
//driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='accountname']")).sendKeys(organization_name);
	
	createNewOrgPage.SaveOrg();
//driver.findElement(By.name("button")).click();
 	
 	//if condtion..........
	 String actualOrgName = Org_info_page.OrganInfo();
//WebElement finalOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
 	 javautil.assertionThroughIfCondition(actualOrgName, organization_name, "validated");
 	
 	homePage.signOut(driver, webDriverLibrary);
 	//WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 	//WebDriverLibrary.mouseHoverOnTheElement(ele1, driver);
 	//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
 	
 	
 	webDriverLibrary.quitBrowser(driver);
   	   
}
}
