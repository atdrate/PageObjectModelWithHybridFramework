package com.bridgelabz.qa.POM.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {

	public static WebDriver driver;
	public static Properties prop;
	static public Properties init_properties;
	XSSFRow row;
	XSSFCell cell;
	protected static String user;
	protected static String pass;

	public Test_Base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\AZ\\eclipse-workspace\\PageObjectModel\\src\\test\\java\\com\\bridgelabz\\qa\\POM\\configs\\config.properties");
			prop.load(ip);
			File file = new File(System.getProperty("user.dir") + "\\resources\\" + "UserPassData" + ".xlsx");
			FileInputStream inputstream = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(inputstream);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(0);
			user = cell.getStringCellValue();
			cell = row.getCell(1);
			pass = cell.getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	public static WebDriver init_driver(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);			
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		return driver;
	}
	
//	public static Properties init_properties() throws IOException {
//		prop = new Properties();
//		FileInputStream ip = new FileInputStream("C:\\Users\\AZ\\eclipse-workspace\\PageObjectModel\\src\\test\\java\\com\\bridgelabz\\qa\\POM\\configs\\config.properties");
//		prop.load(ip);
//		return prop;
//	}
	
//	public static String getMyUrl() {
//		return init_properties.getProperty("url");
//	}
//	public static String getuserName() {
//		return init_properties.getProperty("firstname");
//	}
//	public static String getLastNAme() {
//		return init_properties.getProperty("lastname");
//	}
//	public static String getBrowser() {
//		return init_properties.getProperty("browser");
//	}
}
