package com.bridgelabz.qa.POM.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Pages.Friend_Page;
import com.bridgelabz.qa.POM.Pages.Home_Page;
import com.bridgelabz.qa.POM.Pages.Login_Page;
import com.bridgelabz.qa.POM.Pages.MarketPlace_Page;
import com.bridgelabz.qa.POM.base.Test_Base;

public class HomePage_Test extends Test_Base{

	Login_Page loginPage;
	Home_Page homePage;
	Friend_Page friendsPage;
	MarketPlace_Page marketPlacePage;
	public HomePage_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		friendsPage =new Friend_Page();
		marketPlacePage=new MarketPlace_Page();
    	loginPage = new Login_Page();
    	//homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    	homePage =loginPage.login(user,pass);
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String title = homePage.validatieHomePageTitle();
		Assert.assertEquals(title, "Facebook");
	}
	
	@Test(priority=2)
	public void verifyUSerNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyFriendPage() throws InterruptedException{
		friendsPage=homePage.clickOnFriendList();
		Thread.sleep(5000);
		Assert.assertTrue(homePage.verifyFriendpagelabel());
		Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void verifyMarketPlacePage() throws InterruptedException{
		marketPlacePage=homePage.clickOnMarketPlace();
		Thread.sleep(5000);
		Assert.assertTrue(homePage.verifyMarketplacepagelabel());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
