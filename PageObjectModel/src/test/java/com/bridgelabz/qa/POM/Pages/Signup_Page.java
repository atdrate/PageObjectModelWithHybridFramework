package com.bridgelabz.qa.POM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.base.Test_Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Signup_Page extends Test_Base{
	 @FindBy(linkText = "Sign up for Facebook")
	    WebElement Createnewaccount;
	    
	    @FindBy(name = "firstname")
	    WebElement firstname;
	    
	    @FindBy(name = "lastname")
	    WebElement lastname;
	    
	    @FindBy(name = "reg_email__")
	    WebElement emailaddress;
	    
	    @FindBy(name = "reg_email_confirmation__")
	    WebElement reenteremailaddress;
	    
	    @FindBy(name = "reg_passwd__")
	    WebElement newpassword;
	    
	    @FindBy(name = "birthday_day")
	    WebElement day;
	    
	    @FindBy(name = "birthday_month")
	    WebElement month;
	    
	    @FindBy(name = "birthday_year")
	    WebElement year;
	    
	    @FindBy(xpath = "//input[@value = '2']")
	    WebElement gender;
	    
	    @FindBy(name = "websubmit")
	    WebElement singupbutton;
	    
	    public Signup_Page() {
			PageFactory.initElements(driver, this);
		}
	    

	    
	    public String validatieSignUpTitle() {
			return driver.getTitle();
		}
	
}
