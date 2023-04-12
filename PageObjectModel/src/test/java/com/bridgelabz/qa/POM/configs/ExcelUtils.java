package com.bridgelabz.qa.POM.configs;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bridgelabz.qa.POM.base.Test_Base;

public class ExcelUtils extends Test_Base{
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet; 
	public static void setExcelFile(String path,String sheetName) throws IOException {
		FileInputStream fis =new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
	}
	public static String getCellData(int row,int colomn) {
		Cell cell=sheet.getRow(row).getCell(colomn);
		String  cellData=cell.getStringCellValue();
		return cellData;
	}
}
