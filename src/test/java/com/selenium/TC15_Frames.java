package com.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC15_Frames extends BaseClass_TestNG {

	@Test
	public void NoofFrames() {

		// Start application
		driver.get("https://demoqa.com/frames");

		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
	}

	@Test
	public void SwitchbyIndex() {
		
		driver.get("https://demoqa.com/frames");

		driver.switchTo().frame("frame1");
		// Do all the required tasks in the frame 0
		//*[@id="sampleHeading"]
		WebElement p=driver.findElement(By.xpath("//*[@id='sampleHeading']"));
	   
	      String s= p.getText();
	      System.out.println("Text content is : " + s);
		// Switch back to the main window
		
		
		driver.switchTo().defaultContent();
		
	}
	@Test
public void SwitchnestedFrame() {
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		//driver.switchTo().frame("frameset-middle");
		driver.switchTo().frame("frame-middle");
		

		WebElement p=driver.findElement(By.id("content"));
	   
	      String s= p.getText();
	      System.out.println("Text content is : " + s);
		// Switch back to the main window
		
		
		driver.switchTo().defaultContent();
		
	}
	
	
	

}


