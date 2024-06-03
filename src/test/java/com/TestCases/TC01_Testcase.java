package com.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.POM.Dashboard;
import com.POM.HomePage;
import com.POM.LoginPage;
import com.selenium.BaseClass_TestNG;

import dev.failsafe.internal.util.Assert;

public class TC01_Testcase extends BaseClass_TestNG {
	
	@Test (groups = {"Smoke"})
	public void Testcase_1() throws InterruptedException {
		driver.get("https://demoqa.com/books");
		
		//Creating object of home page
				HomePage home = new HomePage(driver);
				
				//Creating object of Login page
				LoginPage login = new LoginPage(driver);
				
				//Creating object of Dashboard
				Dashboard dashboard = new Dashboard(driver);
				
				//Click on Login button
				home.clickLogin();
				
				
				login.isLoginBtnDisplayed();
				//Enter username & password
				login.enterUsername("---Your Username---");
				login.enterPassword("---Your Password---");
				
				//Click on login button
				login.clickLogin();
				Thread.sleep(3000);
				
				
				//Capture the page heading and print on console
				System.out.println("The page heading is --- " +driver.getTitle());
				
				
	}
	
	@Test
	public void Testcase_2() throws InterruptedException {
		driver.get("https://demoqa.com/books");
		
		//Creating object of home page
				HomePage home = new HomePage(driver);
				
				//Creating object of Login page
				LoginPage login = new LoginPage(driver);
				
				//Creating object of Dashboard
				Dashboard dashboard = new Dashboard(driver);
				
				//Click on Login button
				home.clickLogin();
				
				//Enter username & password
				login.enterUsername("---Your Username---");
				login.enterPassword("---Your Password---");
				
				//Click on login button
				login.clickLogin();
				Thread.sleep(3000);
				
				
				//Capture the page heading and print on console
				System.out.println("The page heading is --- " +dashboard.getHeading());
				
				
	}

}
