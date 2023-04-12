package com.bridgelabz.qa.POM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.bridgelabz.qa.POM.base.Test_Base;

public class Friend_Page extends Test_Base {

	@FindBy(xpath = "//h1[contains(text(),'Friends')]")
	WebElement friendspageLabel;
	
	@FindBy(xpath = ("//a[@href='/friends/requests/']"))
	WebElement friendRequestList;
	
	@FindBy(xpath = "//h1[contains(text(),'Friend requests')]")
	WebElement friendRequestlabel;
	
	public Friend_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFriendsLabel() {
		return friendspageLabel.isDisplayed();
	}

	public  void clickOnFriendRequestList() {
		friendRequestList.click();	
	}
	
	public boolean verifyFriendRequestlabel() {
		return friendRequestlabel.isDisplayed();
	}
}
