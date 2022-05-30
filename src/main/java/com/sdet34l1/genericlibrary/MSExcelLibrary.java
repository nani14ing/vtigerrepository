package com.sdet34l1.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific common methods
 * @author Admin
 *
 */
public class MSExcelLibrary {
	 Workbook wb;

	public void openExcelFile(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fisExcel);
	}
	
	public  Object[][] getMultipleDataFromEcxcel(String sheetName)
	{
		Sheet sh = wb.getSheet(sheetName);
		
		Object[][] arr = new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		for(int i=0; i<=sh.getLastRowNum();i++)
		{
			for(int j=0; j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
	
	
/**
 * This method is used to fetch the data from Excel sheet
 * @param SheetName
 * @param rowNumber
 * @param cellNumber
 * @return
 */
    public  String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
	String data=wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	return data;
	
}

/**
 * This method is used to set the data into excel sheet
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 */
public void insertDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String text) {
	  wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(text);
}

/**
 * This method is used to write the data and to close the excel sheet
 * @param filePath
 * @throws IOException
 */
public  void writeDataIntoExcel(String filePath) throws IOException {
	FileOutputStream fos=new FileOutputStream(filePath);
	wb.write(fos);
}

/**
 * this method is used to close the excel file
 * @throws IOException
 */
public void closeExcelFile() throws IOException {
	wb.close();
}
}

