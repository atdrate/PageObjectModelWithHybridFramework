package com.bridgelabz.qa.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.base.Test_Base;

public class Login_Page extends Test_Base {
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement passwords;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Home_Page login (String un, String pwd) {
		email.sendKeys(un);
		passwords.sendKeys(pwd);
		loginButton.click();
		return new Home_Page();
	}
	


}
