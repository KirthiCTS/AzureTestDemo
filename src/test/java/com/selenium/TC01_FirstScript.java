package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.manager.SeleniumManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_FirstScript {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		//WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		
		
	
		String browserPath = SeleniumManager.getInstance().getDriverPath(co, false).getBrowserPath();
		String driverPath = SeleniumManager.getInstance().getDriverPath(co, false).getDriverPath();
		System.out.println(browserPath);
		System.out.println(driverPath);
		co.setBinary(browserPath);
		co.setBrowserVersion("119");
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		//driver.quit(); 
		
		/*
		 * WebDriverManager.edgedriver().setup(); driver= new EdgeDriver();
		 * 
		 * driver.get("https://www.google.com");
		 * 
		 * driver.quit();
		 */
		
		
	}

}
