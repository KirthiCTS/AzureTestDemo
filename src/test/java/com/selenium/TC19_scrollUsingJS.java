package com.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC19_scrollUsingJS extends BaseClass_TestNG {
	
	@Test
	public void ScrollUsingJS() throws InterruptedException {
		
		driver.get("http://jqueryui.com");
		
		//driver.navigate().refresh();
		
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		
		Thread.sleep(1000);
		
	}

}
