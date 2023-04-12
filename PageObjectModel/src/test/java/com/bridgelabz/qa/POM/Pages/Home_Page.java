package com.bridgelabz.qa.POM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.PageTests.MarketPlacePage_Test;
import com.bridgelabz.qa.POM.base.Test_Base;

public class Home_Page extends Test_Base{
	
	@FindBy(xpath = "//span[contains(text(),'Subodh Nagalwade')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//h1[contains(text(),'Friends')]")
	WebElement friendpageLabel;
	
	@FindBy(xpath = "//h1[contains(text(),'Marketplace')]")
	WebElement marketplacepageLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friendList;
	
	@FindBy(xpath = ("//a[@href='/marketplace/?ref=app_tab']"))
	WebElement marketplace;
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatieHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public boolean verifyFriendpagelabel() {
		return friendpageLabel.isDisplayed();
	}
	
	public boolean verifyMarketplacepagelabel() {
		return marketplacepageLabel.isDisplayed();
	}
	
	public  Friend_Page clickOnFriendList() {
		friendList.click();
		return new Friend_Page();
	}
	
	public  MarketPlace_Page clickOnMarketPlace() {
		marketplace.click();
		return new MarketPlace_Page();
	}
		
	
}
