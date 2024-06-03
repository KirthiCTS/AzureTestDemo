package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08_RadioButton {
	
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
	public void locatingElements1() throws Exception {

		driver.get("https://demoqa.com/radio-button");
		/**
		 * Find radio button using ID, Validate isSelected and then click to select
		 */
		
		Thread.sleep(1000);
		WebElement radioEle = driver.findElement(By.id("yesRadio"));
		boolean select = radioEle.isSelected();
		System.out.print(select);
		// performing click operation if element is not already selected
		if (select == false) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", radioEle);
			//radioEle.click();
		}
		  
		  Thread.sleep(1000);
		 
		/**
		 * Find radio button using Xpath, Validate isDisplayed and click to select
		 */
		WebElement radioElem = driver.findElement(By.xpath("//div/input[@id='impressiveRadio']"));
		boolean sel = radioElem.isSelected();

		// performing click operation if element is displayed
		if (sel == false) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", radioElem);
			//radioElem.click();
		}
		Thread.sleep(1000);
		/**
		 * Find radio button using CSS Selector, Validate isEnabled and click to select
		 */
		WebElement radioNo = driver.findElement(By.cssSelector("input[id='noRadio']"));
		boolean selectNo = radioNo.isEnabled();

		// performing click operation if element is enabled
		if (selectNo == true) {
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click();", radioNo);
			//radioNo.click();
		}
		Thread.sleep(1000);

	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}

}
