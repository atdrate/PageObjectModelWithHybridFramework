package com.bridgelabz.qa.POM.PageTests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Pages.Home_Page;
import com.bridgelabz.qa.POM.Pages.Login_Page;
import com.bridgelabz.qa.POM.Pages.Signup_Page;
import com.bridgelabz.qa.POM.base.Test_Base;
import com.bridgelabz.qa.POM.configs.ExcelUtils;
import com.bridgelabz.qa.POM.configs.KeyWordEngine2;


public class SignupPage_Test extends Test_Base{
	       public KeyWordEngine2 keyWordEngine;
	    	  
	    
	    @Test
	    public void signupWithKeywordDriven() throws InvalidFormatException, IOException, InterruptedException {
	   	 keyWordEngine=new KeyWordEngine2();
	   	 keyWordEngine.startExecution("login");
	    }
}	 

