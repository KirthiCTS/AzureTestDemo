package com.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC12_FluentWaitDemo1 extends BaseClass_TestNG {
	
	@Test
	public void explicitwait() {
		
		// Start application
		driver.get("C:\\Project\\Selenium_Training\\Selenium_Traininng_Workspace\\Selenium_Training\\src\\test\\resources\\HtmlFiles\\DynamicInnterText.html" );

		// Setting FluentWait for list
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						// Check for condition in every 2 seconds
						.pollingEvery(Duration.ofSeconds(2))
						// We need to ignore bcz element is displayed with delay
						.ignoring(NoSuchElementException.class)
						// Till time out i.e. 30 seconds
						.withTimeout(Duration.ofSeconds(30));
				
				WebElement linkText = driver.findElement(By.id("dynamicLink"));
				
				wait.until(ExpectedConditions.textToBePresentInElement(linkText, "Here You Go...."));
				
			
	}

}


