package com.POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

import com.selenium.BaseClass_TestNG;

public class LoginPage  {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver = new ChromeDriver();
	}
	
	//Locator for username field
		private WebElement uname = driver.findElement(By.id("userName"));
		private WebElement pswd = driver.findElement(By.id("password"));
		
		//Locator for password field
	//	By pswd = By.id("password");
		
		//Locator for login button
	//	By loginBtn = By.id("login");
		
		private WebElement loginBtn = driver.findElement(By.id("login"));
		
		//Method to enter username
		public void enterUsername(String user) {
			
			uname.clear();
			uname.sendKeys(user);
			
		}

		//Method to enter password
		public void enterPassword(String pass) {
			pswd.sendKeys(pass);
		}
		
		//Method to click on Login button
		public void clickLogin() {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginBtn);
			//driver.findElement(loginBtn).click();
		}
		
		public void isLoginBtnDisplayed() {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(loginBtn.isDisplayed(), false);
			
			
			//assertEquals(loginBtn.isDisplayed(), false);
			
			
			softAssert.assertAll();
			
		}

}
