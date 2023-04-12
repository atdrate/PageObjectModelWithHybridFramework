package com.bridgelabz.qa.POM.PageTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Pages.Friend_Page;
import com.bridgelabz.qa.POM.Pages.Home_Page;
import com.bridgelabz.qa.POM.Pages.Login_Page;
import com.bridgelabz.qa.POM.base.Test_Base;



public class LoginPage_Test extends Test_Base{
	Login_Page loginPage;
	Home_Page homePage;
	public LoginPage_Test(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
    	loginPage = new Login_Page();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in to Facebook");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
		//homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage =loginPage.login(user,pass);
	    Thread.sleep(5000);
	    String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook");	
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
}

