package com.bridgelabz.qa.POM.configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bridgelabz.qa.POM.base.Test_Base;


public class KeyWordEngine2 extends Test_Base{
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;
	public WebElement element;
	public Test_Base base;

	public  String SCENARIO_SHEET_PATH = "C:\\Users\\AZ\\eclipse-workspace\\PageObjectModel\\resources\\Signup.xlsx";

	public void startExecution(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
	
		
		FileInputStream	file = new FileInputStream(SCENARIO_SHEET_PATH);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount =sheet.getLastRowNum();

		int k = 0;
		for (int i = 0; i < rowCount; i++) {
			String locatorName = "";
			String locatorValue = "";
			
				String locatorColValue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				if (!locatorColValue.equalsIgnoreCase("NA")) {
					locatorName = locatorColValue.split("=")[0].trim();
					locatorValue = locatorColValue.split("=")[1].trim();
				}
				String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
				switch (action) {
				case "open browser":
					init_driver(value);
					break;

				case "enter url":
					driver.get(value);
					break;

				case "quit":
					driver.quit();
					break;

				default:
					break;
				}

				switch (locatorName) {
				case "name":
					WebElement element = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
//						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						Thread.sleep(3000);
						element.click();
					}
					locatorName = null;
					break;
					
				case "id":
					 element = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
//						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					}
					locatorName = null;
					break;

				case "linkText":
					element = driver.findElement(By.linkText(locatorValue));
					element.click();
					locatorName = null;
					break;
					

				case "xpath":
					element = driver.findElement(By.xpath(locatorValue));
					element.click();
					locatorName = null;
					break;

				default:
					break;
				}
			}
			
		}
}
