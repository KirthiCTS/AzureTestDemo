package com.selenium;

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

public class TC07_GetText {
	
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

		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // identify element
	      WebElement p=driver.findElement(By.xpath("//h2[3]"));
	      //getText() to obtain text
	      String s= p.getText();
	      System.out.println("Text content is : " + s);
		

	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}

}
