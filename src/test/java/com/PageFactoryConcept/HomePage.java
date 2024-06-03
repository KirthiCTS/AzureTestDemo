package com.PageFactoryConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.BaseClass_TestNG;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")

	WebElement LoginBtn;

	// Locator for login button
	// By LoginBtn = By.id("login");

	// Method to click login button
	public void clickLogin() {
		LoginBtn.click();
	}

}
