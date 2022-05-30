package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class CreateDocumentsTest {
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
	//String camp_name = PropertyFileLibrary.getdataFromPropertyFile("camp_name");
	String browser =propertyFileLibrary.getdataFromPropertyFile("Browser");
	String timeout = propertyFileLibrary.getdataFromPropertyFile("timeout");
	
	long longtime = javautil.stringToLong(timeout);
	
	int randomNumber=javautil.getRandomNumber(1000);

	
	String Doc_title = msExcelLibrary.getDataFromExcel("Documents", 4, 1)+randomNumber;
	String Doc_path = msExcelLibrary.getDataFromExcel("Documents", 4, 2);
	String Doc_desc = msExcelLibrary.getDataFromExcel("Documents", 4, 3)+randomNumber;
	
	
    /*
	FileInputStream fisExcel=new FileInputStream("./src/test/resources/ex.xlsx");
	Workbook wb=WorkbookFactory.create(fisExcel);
	String Doc_title=wb.getSheet("Documents").getRow(4).getCell(1).getStringCellValue()+randomNumber;
	String Doc_path=wb.getSheet("Documents").getRow(4).getCell(2).getStringCellValue()+randomNumber;
	String Doc_desc=wb.getSheet("Documents").getRow(4).getCell(3).getStringCellValue()+randomNumber;
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
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	}
	
	WebDriverLibrary webDriverLibrary = new WebDriverLibrary();
	
	webDriverLibrary.navigateApp(url, driver);
	webDriverLibrary.expclicitlyWait(driver, longtime);	
	webDriverLibrary.maximizeBrowser(driver);
	
	LoginPage loginpage=new LoginPage(driver);
	HomePage homepage=new HomePage(driver);
	DocumentsPage doc_page=new DocumentsPage(driver);
	CreateNewDocumentsPage  createNewDocPage=new CreateNewDocumentsPage(driver) ;
	
	/*
	driver.get(url);
	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(longtime, TimeUnit.SECONDS);
 	*/
 	
	loginpage.loginAction(un, pwd);

	homepage.clickOnDocuments();
 //driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
 	
 	doc_page.createDocumentIcon();
 //driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
 
 	createNewDocPage.documentTitle(driver, Doc_title);
 //driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(Doc_title);
 	
 
 	//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")));
 	webDriverLibrary.switchToFrame(driver, 0); 
	 
	 createNewDocPage.descriptionArea(driver, Doc_desc);
   //driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(Doc_desc, Keys.CONTROL+"a");
     
	 
	 webDriverLibrary.switchBackToHome(driver);
 	
   // driver.switchTo().defaultContent();//frame to outside..  
    
     createNewDocPage.boldAndItalic();
   //driver.findElement(By.xpath("//a[@id='cke_5']")).click();
   //driver.findElement(By.xpath("//a[@id='cke_6']")).click();
     
     Thread.sleep(2000);
     createNewDocPage.chooseFileBtn(Doc_path);
    //driver.findElement(By.id("filename_I__")).sendKeys(Doc_path);
     
     createNewDocPage.saveDocuments();
   //driver.findElement(By.xpath("//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")).click();
    
    
    homepage.signOut(driver, webDriverLibrary);
//WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//WebDriverLibrary.mouseHoverOnTheElement(ele1, driver);
	//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	
    webDriverLibrary.quitBrowser(driver);

}
}
