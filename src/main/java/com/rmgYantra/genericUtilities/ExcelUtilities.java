package com.rmgYantra.genericUtilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {

	public String toReadDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("/Users/alppyamit/Desktop/Selenium Qspider/RmgYantraFramework/src/test/resources/config/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public int toGetLastRowNum(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("/Users/alppyamit/Desktop/Selenium Qspider/RmgYantraFramework/src/test/resources/config/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		return lastRowNum;
	}
	
}
