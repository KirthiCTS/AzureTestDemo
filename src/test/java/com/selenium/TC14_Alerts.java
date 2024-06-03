package com.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC14_Alerts extends BaseClass_TestNG {

	@Test
	public void AcceptAlerts() {

		// Start application
		driver.get("https://demoqa.com/alerts");

		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		
	}

	@Test
	public void AcceptAlertswithinput() {
		
		driver.get("https://demoqa.com/alerts");
		  
		  WebElement element = driver.findElement(By.id("promtButton"));
		  
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("arguments[0].click();", radioEle);
			 */
			
			
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		   Alert promptAlert  = driver.switchTo().alert();
		   String alertText = promptAlert.getText();
		   System.out.println("Alert text is " + alertText);
		  //Send some text to the alert
		   promptAlert.sendKeys("Test User");
		   promptAlert.accept();
		
	}
	
	@Test
	public void unexpectedAlerts() {
		
		driver.get("https://demoqa.com/alerts");
		try {
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
		
	}

}


