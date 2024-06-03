package com.PageFactoryConcept;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selenium.BaseClass_TestNG;
import com.selenium.helperutils.LocatorsHelper;

public class Dashboard {
	WebDriver driver;


	    @FindBy(how= How.XPATH, xpath="//div[@class='main-header']")
	    private WebElement heading;

	    @FindBy(id="submit")
	    private WebElement logoutBtn;    

	   

	public Dashboard(WebDriver driver) {
		this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}

	// Locators for the page title and the logout button
	//By heading = By.xpath("//div[@class=\"main-header\"]");
	//By logoutBtn = By.id("submit");

	// Method to capture the page heading
	public String getHeading() {
		String head = heading.getText();
		return head;
	}

	

}
