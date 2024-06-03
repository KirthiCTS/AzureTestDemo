package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.BaseClass_TestNG;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	// Locators for the page title and the logout button
	By heading = By.xpath("//div[@class=\"main-header\"]");
	By logoutBtn = By.id("submit");

	// Method to capture the page heading
	public String getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}

	

}
