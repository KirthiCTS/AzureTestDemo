package com.selenium;

import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC10_UsingImplicitWait extends BaseClass_TestNG {
	
	@Test
	public void implicitwait () {
		// Loading a URL
				driver.get("https://www.redbus.in/");
				
				// Locating and typing in From text box. 
				WebElement fromTextBox= driver.findElement(By.id("src"));
				fromTextBox.sendKeys("Ban");
				 long start2 = System.currentTimeMillis();
			      
				System.out.println("Wait starts at :"+new Date());
				// Clicking on first search result
				driver.findElement(By.xpath("//*[@id=\"homeV2-root\"]/div[1]/div[1]/div/div[1]/div/div[1]/ul/li[1]")).click();
				System.out.println("Wait ends at:"+new Date());
				long end2 = System.currentTimeMillis();    
				System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
	}
	
	@Test
	public void UsingImplicitWaitWithTimeOut() {
		// Loading a URL
		driver.get("https://www.redbus.in/");

		// Locating and typing in From text box.
		WebElement fromTextBox = driver.findElement(By.id("src"));
		fromTextBox.sendKeys("Ban");
		 long start2 = System.currentTimeMillis();
		System.out.println("Wait starts at :" + new Date());
		// Passing wrong locators and catching exception to show waiting time
		try {
			driver.findElement(By.xpath("//*[@id='homeV2-root']/div[1]/div[1]/div/div[1]/div/div[1]/ul/li[1]")).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Wait ends at:"+new Date());
			long end2 = System.currentTimeMillis();    
			System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
		}
		finally
        {
			System.out.println("Wait ends at:"+new Date());
			long end2 = System.currentTimeMillis();    
			System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
        }
		
	}

}
