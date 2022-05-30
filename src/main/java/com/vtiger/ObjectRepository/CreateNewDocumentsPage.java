package com.vtiger.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverLibrary;

public class CreateNewDocumentsPage 
{

	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	
	
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement documentTitleTxt;
	
	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveDocumentBtn;
	
	@FindBy(xpath = "//a[@id='cke_5']")
	private WebElement boldIcon;
	
	@FindBy(xpath = "//a[@id='cke_6']")
	private WebElement italicIcon;
	
	@FindBy(xpath = "//html[@dir='ltr']")
	private WebElement descriptionArea;

	
	
	public CreateNewDocumentsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void documentTitle(WebDriver driver, String doc_title)
	{
		documentTitleTxt.sendKeys(doc_title);
		webDriverLibrary.expclicitlyWait(driver, 10);
		 
		webDriverLibrary.switchToFrame(driver, 0);
	}
	
	
	public void chooseFileBtn(String filepath) 
	{
		chooseFileBtn.sendKeys(filepath);
	}
	
	
	public void saveDocuments()
	{
		saveDocumentBtn.click();
	}
	
	
	public void boldAndItalic()
	{
		boldIcon.click();
		italicIcon.click();
		
	}
	
	
	public void descriptionArea(WebDriver driver, String message) 
	{
		descriptionArea.sendKeys(message, Keys.CONTROL+"a");
		webDriverLibrary.expclicitlyWait(driver, 10);
	}

}
