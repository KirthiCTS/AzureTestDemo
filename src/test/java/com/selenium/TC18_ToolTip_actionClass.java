package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_ToolTip_actionClass extends BaseClass_TestNG {

	@Test
	public void VerifyErrorMessage() {

		// Start application
		driver.get("https://demoqa.com/tool-tips");
		
		// Create action class object
		Actions builder=new Actions(driver);

		// find the tooltip/helptext message xpath
		WebElement tooltip=driver.findElement(By.id("toolTipButton"));

		// Mouse hover to that text
		builder.moveToElement(tooltip).perform();

		// Extract the text from tooltip using getText
		String tooltip_msg=tooltip.getText();

		 // Print the tooltip message
		System.out.println("Tooltip message is "+tooltip_msg);

		// This is expected message should come and store in variable
		 String expected_tooltip="Hover me to see";

		// It will compare if actual matches with expected then TC will fall else it will fail
		Assert.assertEquals(tooltip_msg, expected_tooltip);

		System.out.println("Message verifed");
	}

	
	

}


