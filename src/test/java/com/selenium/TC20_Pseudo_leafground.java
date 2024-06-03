package com.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC20_Pseudo_leafground extends BaseClass_TestNG {
	
	@Test
	public void browserclick() throws InterruptedException {
		
		driver.get("https://leafground.com/");
		
		//driver.findElement(By.cssSelector("li#menuform:j_idt39")).click();
		
		driver.findElement(By.xpath("//*[@id='menuform:j_idt39']")).click();
		
		Thread.sleep(1000);
		
		//*[@id="menuform:j_idt39"]/a/i[1]
		
		
		driver.findElement(By.xpath("//*[@id='menuform:m_overlay']")).click();
		
		Thread.sleep(1000);
		
	}
	
	@Test
	public void Pseudo_example() throws InterruptedException {
		
		driver.get("https://monica-official.github.io/Pseudo-Elements/sample-pseudo-element.html");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return window.getComputedStyle(document.querySelector('.submitButton'),'::before').getPropertyValue('content')")
                .toString();
        js.executeScript("return window.getComputedStyle(document.querySelector('.submitButton'),'::before').click()");
        System.out.print(text);
		
	}
	
	
	@Test
	public void Pseudo_example1() throws InterruptedException {
		
		driver.get("https://leafground.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = 
        		js.executeScript("return window.getComputedStyle(document.querySelector('.pi.pi-globe.layout-menuitem-icon'),'::before').getPropertyValue('content')")
                .toString();
 
        System.out.print(text);
        
        Actions build = new Actions(driver);
        build.moveToElement(driver.findElement(By.cssSelector(".pi.pi-globe.layout-menuitem-icon"))).click().build().perform();
        
        //click some where in the page to esc previous click
        
        driver.findElement(By.cssSelector(".pi.pi-home")).click();
        
        WebElement cssPath =driver.findElement(By.cssSelector(".pi.pi-globe.layout-menuitem-icon"));
       // ((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",cssPath);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cssPath);
        Thread.sleep(1000);
	}
	
	
	@Test
	public void Pseudo_Click_example() {
		driver.get("https://the-internet.herokuapp.com/inputs");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Actions build = new Actions(driver);
        build.moveToElement(driver.findElement(By.cssSelector("input[type=number]"))).click().build().perform();
        build.moveToElement(driver.findElement(By.cssSelector("input[type=number]"))).click().build().perform();
        build.moveToElement(driver.findElement(By.cssSelector("input[type=number]"))).click().build().perform();
        
		System.out.println("Clicked");
		
	}
	
	@Test
	public void redbus() {
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.id("hc")).click();
		
		//driver.findElement(By.)
		
		
	}
	
	

}
