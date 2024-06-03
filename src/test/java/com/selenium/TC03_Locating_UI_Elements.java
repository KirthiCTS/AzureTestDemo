package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_Locating_UI_Elements {

//	Id
//	Name
//	LinkText
//	PartialLinkText
//	Tag name
//	Class name
//	CSS
//	XPATH

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
	public void locatingElements1() {

		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);

		String username = "Admin";
		String password = "admin123";
		
		

		driver.findElement(By.name("username")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// driver.findElement(By.className("oxd-button oxd-button--medium
		// oxd-button--main orangehrm-login-button"))

		driver.close();
		driver.quit();

	}

	@Test
	public void locatingElements2() {

		String url = "https://demoqa.com/text-box";
		driver.get(url);
		// Full name using ID
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("TamilSelvi");
		// Email using Class name
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("seleniumtest@gamil.com");

		// css selector using tag#id

		driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("Chennai");

		// Submit using Class name
		// driver.findElement(By.className("btn btn-primary")).click();

		System.out.println("Completed with 2nd method");
		driver.close();
		driver.quit();

	}

	@Test
	public void locatingElements3() {

		driver.get("http://leaftaps.com/opentaps/control/login");

		// driver.findElement(By.locator("value");

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.partialLinkText("Create")).click();

		System.out.println("Completed with 3nd method");
		driver.close();
		driver.quit();

	}

}
