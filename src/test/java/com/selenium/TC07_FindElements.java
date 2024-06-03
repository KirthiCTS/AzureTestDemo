package com.selenium;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07_FindElements {
	
	public static WebDriver driver;
	String browser = "chrome";

	@BeforeMethod
	public void invokeBrowser() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void findElementsExample() throws Exception {

	//	driver.get("https://demoqa.com/text-box/");
		driver.get("https://www.google.co.in/");

		// driver.findElement(By.locator("value");

		//List<WebElement> allInputElements = driver.findElements(By.tagName("input"));
		List<WebElement> allInputElements = driver.findElements(By.tagName("a"));
		
		   if(allInputElements.size() != 0) 
		   {
			   System.out.println(allInputElements.size() + " Elements found by TagName as input \n");
				
			   for(WebElement inputElement : allInputElements) 
			   {
				 //  System.out.println(inputElement.getAttribute("placeholder"));
				   System.out.println(inputElement.getText());
			   }
		   }
		

	}
	
	@Test
	public void findNonPresentElementExample() {

	
		driver.get("https://demoqa.com/text-box/");

		System.out.println("Start Time: " + new Date());
		List<WebElement> fullName = driver.findElements(By.id("userNameWrong"));
		System.out.println("Total elements found : "+ fullName.size());
		System.out.println("End Time: " + new Date());

	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}

}
