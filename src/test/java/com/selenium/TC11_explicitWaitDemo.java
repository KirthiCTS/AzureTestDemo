package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC11_explicitWaitDemo extends BaseClass_TestNG {
	
	@Test
	public void explicitwait() {
		
		// Start application
				driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

				// Click on timer button to start
				driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

				// Create object of WebDriverWait class and it will wait max of 20 seconds.
				// By default it will accepts in Seconds
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				// Here we will wait until element is not visible, if element is visible then it will return web element
				// or else it will throw exception
				WebElement element = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

				// if element found then we will use- In this example I just called isDisplayed method
				boolean status = element.isDisplayed();

				// if else condition
				if (status) {
					System.out.println("===== WebDriver is visible======");
				} else {
					System.out.println("===== WebDriver is not visible======");
				}
	}

}


