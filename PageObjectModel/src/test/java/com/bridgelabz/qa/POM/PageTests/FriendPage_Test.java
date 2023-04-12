package com.bridgelabz.qa.POM.PageTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Pages.Friend_Page;
import com.bridgelabz.qa.POM.Pages.Home_Page;
import com.bridgelabz.qa.POM.Pages.Login_Page;
import com.bridgelabz.qa.POM.base.Test_Base;

public class FriendPage_Test extends Test_Base{
	Login_Page loginPage;
	Home_Page homePage;
	Friend_Page friendsPage;
	
	public FriendPage_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
    	loginPage = new Login_Page();
    	//homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    	homePage =loginPage.login(user,pass);
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	friendsPage= homePage.clickOnFriendList();
    	Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void verifyFriendPageLabelTest(){
		Assert.assertTrue(friendsPage.verifyFriendsLabel(), "Friend label is missing");
	}
	
	@Test(priority=2)
	public void clickOnFriendRequest() throws InterruptedException{
		friendsPage.clickOnFriendRequestList();
		Thread.sleep(5000);
		Assert.assertTrue(friendsPage.verifyFriendRequestlabel());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
