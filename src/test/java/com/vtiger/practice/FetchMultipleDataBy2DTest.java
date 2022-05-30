package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataBy2DTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream fisexcel=new FileInputStream("./src/test/resources/ex.xlsx");
    Workbook wb = WorkbookFactory.create(fisexcel);
    Sheet sh = wb.getSheet("multipledata");
    Object[][] arr = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
    for(int i=1; i<sh.getLastRowNum(); i++)
    {
    	for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
    	{
    		arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
    	}
    }
    System.out.println(arr[2][1]);
}
}
