package com.bridgelabz.qa.POM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.PageTests.MarketPlacePage_Test;
import com.bridgelabz.qa.POM.base.Test_Base;

public class MarketPlace_Page extends Test_Base{

	
	@FindBy(xpath = ("//a[@href='/marketplace/?ref=app_tab']"))
	WebElement marketplace;
	
	@FindBy(xpath = ("//a[@href='/marketplace/category/vehicles/']"))
	WebElement vehicles;
	
	@FindBy(xpath = "//span[contains(text(),'Vehicles')]")
	WebElement vehiclelabel;
	
	public MarketPlace_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMarketPlaceLabel() {
		return marketplace.isDisplayed();
	}
	
	public  MarketPlace_Page clickOnVehicles() {
		vehicles.click();
		return new MarketPlace_Page();
	}
	
	public boolean verifyVehicleslabel() {
		return vehiclelabel.isDisplayed();
	}
}
