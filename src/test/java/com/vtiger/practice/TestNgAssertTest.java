package com.vtiger.practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgAssertTest {

	@Test
	public void practice1Test() {
		Reporter.log("a-practice1", true);
		Reporter.log("b-practice1", true);
		Reporter.log("c-practice1", true);
		Reporter.log("d-practice1", true);
		Assert.fail();
		Reporter.log("e-practice1", true);		
	}
	
	@Test
	public void practice2Test() {
		Reporter.log("f-practice2", true);
		Reporter.log("g-practice2", true);
		Reporter.log("h-practice2", true);
		Reporter.log("i-practice2", true);
		Assert.fail();
		Reporter.log("j-practice2", true);		
	}
	
	@Test
	public void practice3Test() {
		Reporter.log("k-practice3", true);
		Reporter.log("l-practice3", true);
		Reporter.log("m-practice3", true);
		Reporter.log("n-practice3", true);
		Assert.fail();
		Reporter.log("e-practice3", true);		
	}
	
	
	@Test
	public void practiceTest() {
		Reporter.log("a-practice4", true);
		Reporter.log("b-practice4", true);
		Reporter.log("c-practice4", true);
		Reporter.log("d-practice4", true);
		Assert.fail();
		Reporter.log("e-practice4", true);		
	}
	
	
}
