package com.bridgelabz.qa.POM.PageTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Pages.Friend_Page;
import com.bridgelabz.qa.POM.Pages.Home_Page;
import com.bridgelabz.qa.POM.Pages.Login_Page;
import com.bridgelabz.qa.POM.Pages.MarketPlace_Page;
import com.bridgelabz.qa.POM.base.Test_Base;

public class MarketPlacePage_Test extends Test_Base{

	Login_Page loginPage;
	Home_Page homePage;
	Friend_Page friendsPage;
	MarketPlace_Page marketPlacePage;
	public MarketPlacePage_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
    	loginPage = new Login_Page();
    	//homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    	homePage =loginPage.login(user,pass);
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	marketPlacePage= homePage.clickOnMarketPlace();
	}
	
	@Test(priority=1)
	public void marketPlacePageTitleTest(){
		Assert.assertTrue(marketPlacePage.verifyMarketPlaceLabel(), "market Place Page Title is missing");
	}
	
	@Test(priority=2)
	public void clickOnVehiclesTest() throws InterruptedException{
		marketPlacePage.clickOnVehicles();
		Thread.sleep(5000);
		Assert.assertTrue(marketPlacePage.verifyVehicleslabel());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
