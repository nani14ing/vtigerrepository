package com.sdet34l1.genericlibrary;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * this class contains only java specific reusable files
 * @author Admin
 *
 */
public class JavaLibrary {
    /**
     * this method is used to convert String To Long datatype
     * @param value
     * @return
     */
	public long stringToLong(String value) {
		return Long.parseLong(value);
	}
	
	
	
	/**
	 * this method is used to get the random number
	 * @param limit
	 * @return
	 */
	public  int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	
	
	
	/**
	 * This method is used to print the statement
	 * @param message
	 */
	public void printStatement(String message) {
		System.out.println(message);
	}
	
	
	/**
	 * This method is used for the If conditon
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */
	public void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName) {
	if(actualResult.equalsIgnoreCase(expectedResult))
	{
	System.out.println(testCaseName+"created successfully");
	System.out.println("TC pass");
	}
	}
	
	
	public void customWait(WebElement element, long polling_time, int duration) throws InterruptedException {
		int count=0;
		while(count<=duration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(polling_time);
				count++;
			}
		}
	}



	public String dateTimeInFormat() {
		// TODO Auto-generated method stub
		
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date(0));
	}
	
}











