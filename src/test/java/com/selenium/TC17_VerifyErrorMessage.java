package com.selenium;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17_VerifyErrorMessage extends BaseClass_TestNG {

	@Test
	public void VerifyErrorMessage() {

		// Start application
		driver.get("https://www.naukri.com/nlogin/login");

		// Click on login button
		driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div[3]/div/button[1]")).click();
		        
		// This will capture error message
		String actual_msg=driver.findElement(By.id("usernameField_err")).getText();
		    
		// Store message in variable
		String expect="Email ID/Username cannot be left blank";
		                
		// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
		//exception and fail testcases

		// Verify error message
		Assert.assertEquals(actual_msg, expect);
	}

	@Test
	public void ClickusingRobotClass() throws AWTException {
		
		driver.get("https://demoqa.com/");

		// Create object of Robot class
		Robot robot = new Robot();
		 
		// This will press Escape key on keyboard.
		
		  robot.keyPress(KeyEvent.VK_ESCAPE);
		  
		  // This will release the CAPS_LOCK key.
		  robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		  
		  // This will press Left mouse button.
		  robot.mousePress(InputEvent.BUTTON1_MASK);
		  
		  // This will release Left mouse button.
		  robot.mouseRelease(InputEvent.BUTTON1_MASK);
		 
		 
		org.openqa.selenium.Point coordinates = driver.findElement(By.id("img_location")).getLocation();
		 
		robot.mouseMove(coordinates.getX(), coordinates.getY());
		
	}
	
	

}


