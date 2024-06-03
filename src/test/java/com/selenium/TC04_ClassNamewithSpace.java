package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04_ClassNamewithSpace {
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

		driver.get("https://ui.cogmento.com/");

		// driver.findElement(By.locator("value");

		WebElement user = driver.findElement(By.name("email"));
		user.sendKeys("Automate.Samplecoe@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("Tech@1234");
		
	
		//driver.findElement(By.className("ui fluid large blue submit button")).click();
		
		  //Go with Css locator 
			
			  WebElement l
			  =driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button"));
			  //verify if element is displayed 
			  boolean b = l.isDisplayed();
			  System.out.println(b); l.click();
			 
		 

	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}
	

}
