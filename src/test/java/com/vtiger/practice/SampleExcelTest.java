package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class SampleExcelTest {
public static void main(String[] args) throws IOException {
	
	//step1:convert physical file to java readable object
	FileInputStream fis = new FileInputStream("./src/test/resources/ex.xlsx");


    //step2:get excel 
    Workbook wb = WorkbookFactory.create(fis);
    
    //step3:get sheet
    Sheet sh = wb.getSheet("example");
    
    //step4: get row
    Row rw = sh.getRow(1);
    
    //step5: get cell
    Cell cell = rw.getCell(0);
    
    //step6:fetch data from cell
    String data = cell.getStringCellValue();
    System.out.println(data);
    
    //step7:
    wb.close();


}
}