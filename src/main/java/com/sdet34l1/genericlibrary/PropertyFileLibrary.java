package com.sdet34l1.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property file specific common methods
 * @author Admin
 *
 */
public class PropertyFileLibrary {
	   Properties property;
	
	/**
	 * this method is used to open the property file
	 * @param filePath
	 * @throws IOException
	 */
	public void openPropertyFile(String filePath) throws IOException {
		FileInputStream fis=new FileInputStream(filePath);
		property =new Properties();
		property.load(fis);
	}
	
	/**
	 * This method is used to get the data from the property file
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	
	public String getdataFromPropertyFile(String key) {
		//openPropertyFile(key);
		String value = property.getProperty(key);
		return value;
	}
    
}
