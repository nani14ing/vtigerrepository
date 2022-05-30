package com.sdet34l1.genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public int randomNumber;
	public String pwd;
	public String un;
	public long longtime;
	public WebDriver driver;
	public LoginPage loginpage;
	public 	HomePage homepage;
	public JavaLibrary javautil;
	public WebDriverLibrary webDriverLibrary;
	public PropertyFileLibrary propertyFileLibrary;
	public MSExcelLibrary msExcelLibrary;
	public static WebDriver staticdriver;
	
	
	/**
	 * this Annotation is used to open the Excel, Database and Property File.
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuite1Test() throws IOException {

		//PropertyFileLibrary propertyFileLibrary=new PropertyFileLibrary();
		//MSExcelLibrary msExcelLibrary=new MSExcelLibrary();
		
		//propertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		//msExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
		
	}
	
	/**
	 * this annotation is used to launch the browser, 
	 * browser settings, 
	 * create the instance of implicit and explicit wait.
	 * @throws IOException 
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClass1Test() throws IOException {

		propertyFileLibrary=new PropertyFileLibrary();
	 msExcelLibrary=new MSExcelLibrary();
		
		propertyFileLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		msExcelLibrary.openExcelFile(IconstantPath.EXCELFILEPATH);
		
		
		
	 webDriverLibrary=new WebDriverLibrary();
		javautil=new JavaLibrary();
		//String url = propertyFileLibrary.getdataFromPropertyFile("url");
		//un = propertyFileLibrary.getdataFromPropertyFile("UN");
		//pwd = propertyFileLibrary.getdataFromPropertyFile("PWD");
		String browser = propertyFileLibrary.getdataFromPropertyFile("Browser");
		String timeout = propertyFileLibrary.getdataFromPropertyFile("timeout");		
		longtime = javautil.stringToLong(timeout);	
		randomNumber=javautil.getRandomNumber(1000);
		String url = System.getProperty("URL");
		String un = System.getProperty("UN");
		String pwd = System.getProperty("PWD");
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			driver=new ChromeDriver();
			break;
		}
		 staticdriver=driver;
		webDriverLibrary.maximizeBrowser(driver);	
		webDriverLibrary.expclicitlyWait(driver, longtime);
		webDriverLibrary.initializeActions(driver);
		
		loginpage=new LoginPage(driver);
	    homepage=new HomePage(driver);
		
	    webDriverLibrary.navigateApp(url, driver);
	}
	
	
	/**
	 * this annotation is used for the login actions purpose.
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethod1Test() {
		loginpage.loginAction(un, pwd);
	}
	
	
	/**
	 * this annotation is used for the logout actions purpose.
	 */
	@AfterMethod(groups="baseclass")
	public void afteMethod1test() {
		homepage.signOut(driver, webDriverLibrary);
	}
	
	
	/**
	 * this annotation is used to close the browser.
	 */
	@AfterClass(groups="baseclass")
	public void afterClass1Test() {
		webDriverLibrary.quitBrowser(driver);
	}
	
	
	/**
	 * this annotation is used to close the excel, Database, and property file.
	 * @throws Throwable
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuite1Test() throws Throwable {
		msExcelLibrary.closeExcelFile();
	}
}
