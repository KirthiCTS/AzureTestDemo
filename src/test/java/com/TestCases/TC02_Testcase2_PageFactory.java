package com.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.PageFactoryConcept.Dashboard;
import com.PageFactoryConcept.HomePage;
import com.PageFactoryConcept.LoginPage;
import com.selenium.BaseClass_TestNG;

public class TC02_Testcase2_PageFactory extends BaseClass_TestNG {

	@Test
	public void Testcase_1() throws InterruptedException {
		driver.get("https://demoqa.com/books");

		// Creating object of home page
		// HomePage home = PageFactory.initElements(driver, HomePage.class);
		HomePage home = new HomePage(driver);

		// Creating object of Login page
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		// Creating object of Dashboard
		Dashboard dashboard = new Dashboard(driver);

		// Click on Login button
		home.clickLogin();

		// Enter username & password
		login.enterUsername("Your Username");
		login.enterPassword("---Your Password---");

		// Click on login button
		login.clickLogin();
		Thread.sleep(3000);

		// Capture the page heading and print on console
		System.out.println("The page heading is --- " + dashboard.getHeading());

	}

}
