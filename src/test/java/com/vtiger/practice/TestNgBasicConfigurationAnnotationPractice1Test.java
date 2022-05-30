package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasicConfigurationAnnotationPractice1Test {
	
	@Test
	public void test1Test() {
		Reporter.log("test1", true);
	}
	
	
	@Test
	public void test2Test() {
		Reporter.log("test2", true);
	}
	
    @BeforeSuite
	public void beforeSuiteTest1()
	{
	Reporter.log("beforeSuite1",true);
	}

    @AfterSuite
	public void afteSuiteTest1()
	{
	Reporter.log("aftereSuite1",true);
	}


    @BeforeClass
	public void beforeClassTest1()
	{
	Reporter.log("beforeClass1",true);
	}

    @AfterClass
   	public void afterClassTest1()
   	{
   	Reporter.log("afterClass1",true);
   	}
    
    @BeforeTest
   	public void beforTestTest1()
   	{
   	Reporter.log("beforeTest1",true);
   	}
    
    @AfterTest
   	public void afterTestTest1()
   	{
   	Reporter.log("afterTest1",true);
   	}
    
    @BeforeMethod
   	public void beforeMethodTest1()
   	{
   	Reporter.log("beforeMethod1",true);
   	}
    
    @BeforeMethod
   	public void beforeMethodTest2()
   	{
   	Reporter.log("beforeMethod2",true);
   	}
    
    
    @AfterMethod
   	public void afterMethodTest1()
   	{
   	Reporter.log("afterMethod1",true);
   	}
   
}
