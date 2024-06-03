package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.helperutils.LocatorsHelper;

public class OrangeHRMSLoginPage {
	WebDriver driver;

	public OrangeHRMSLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement username = driver.findElement(By.name(LocatorsHelper.username));
	
	// Locator for username field
	By uName = By.name("username");

	// Locator for password field
	By pswd = By.name("password");

	// Locator for login button
	By loginBtn = By.xpath("//button[@type='submit']");

	// Method to enter username
	public void SetUsername(String user) {

		username.sendKeys(user);
		//driver.findElement(uName).sendKeys(user);
	}

	// Method to enter password
	public void SetPassword(String pass) {
		driver.findElement(pswd).sendKeys(pass);
	}

	// Method to click on Login button
	public void clickLogin() {
		WebElement login = driver.findElement(loginBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", login);
		// driver.findElement(loginBtn).click();
	}

	public void GetURL(String url) {
		driver.get(url);
	}

	
}
