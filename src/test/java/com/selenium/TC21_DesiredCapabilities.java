package com.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC21_DesiredCapabilities {
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("disable-gpu");

		DesiredCapabilities capa= new DesiredCapabilities();
		
		capa.setCapability("browsername", "chrome");
		capa.setCapability("version", "109");
		//capa.setJavascriptEnabled(true);
		
		chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Navigate to toolsQA site url
        driver.get("https://demoqa.com/");
        
        //Print the Title of the Page
        System.out.println("Title of the page is -> " + driver.getTitle());
        
        //Close the driver
        driver.close();
        driver.quit();
		
	}

}
