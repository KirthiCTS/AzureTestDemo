package com.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_TestNG {
	
	public static WebDriver driver;
	String browser = "chrome";
	
	
	@DataProvider
	public Object[][] loginmethod(){
		
		
		
		return new Object[][] {{"Admin","admin123"}};
	}
	@BeforeMethod
	public void invokeBrowser() {
		
		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup()
			ChromeOptions co = new ChromeOptions();
			//co.setBrowserVersion("119");
			String browserPath = SeleniumManager.getInstance().getDriverPath(co, false).getBrowserPath();
			String driverPath = SeleniumManager.getInstance().getDriverPath(co, false).getDriverPath();
			co.setBinary(browserPath);
			driver = new ChromeDriver(co);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}

}
