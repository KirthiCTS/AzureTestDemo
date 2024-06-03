package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC22_Gmail {
	
	@Test
	public void gmail() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("disable-gpu");
		chromeOptions.addArguments("--disable-web-security");
		//chromeOptions.addArguments("--user-data-dir");
		chromeOptions.addArguments("--allow-running-insecure-content");
		
		
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Navigate to toolsQA site url
        driver.get("https://accounts.google.com/");
        
       // driver.findElement(By.linkText("Use another account")).click();
        
        //Print the Title of the Page
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("Automate.Samplecoe@gmail.com");
        
        driver.findElement(By.name("password")).sendKeys("Tech@1234");
        
        //Close the driver
        driver.close();
        driver.quit();
		
	}

}
;