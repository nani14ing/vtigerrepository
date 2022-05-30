package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFileTest {
public static void main(String[] args) throws IOException {
	//step1:convert external files to java readable file
	FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.properties");
	
	//step2:create object for the property file
	Properties P = new Properties();
	
	//step3:load all the keys
	P.load(fis);
	
	//step4:fetch the data by using key
	String url = P.getProperty("url");
	String un = P.getProperty("UN");
	String pwd = P.getProperty("PWD");
	String lastname = P.getProperty("LN");
	String browser = P.getProperty("firefox");
	String timeout = P.getProperty("timeout");
	
	System.out.println(url);
	System.out.println(un);
	System.out.println(pwd);
	System.out.println(lastname);
	System.out.println(browser);
	System.out.println(timeout);
}
}
