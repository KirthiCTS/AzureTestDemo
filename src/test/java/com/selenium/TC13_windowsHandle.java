package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC13_windowsHandle extends BaseClass_TestNG {

	@Test
	public void windowhandles() {

		// Start application
		driver.get("https://demoqa.com/browser-windows");

		// Open new child window within the main window
		driver.findElement(By.id("windowButton")).click();

		// Get handles of the windows
		//It stores parent window value in a unique identifier of string type.
		String mainWindowHandle = driver.getWindowHandle();
		
		//All child windows are stored in a set of strings.
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		//Here we will iterate through all child windows.
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is " + text.getText());
			}
		}
	}
	
	@Test
	public void WorkingOfWindowHandle() {
		
		  driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		  
		  try {
	            //Clicks on the follow on twitter option
	           // WebElement followOnTwitter = driver.findElement(By.xpath("//a[text()='  Follow On Twitter ']"));
	            WebElement followOnTwitter = driver.findElement(By.xpath("//a[text()='Follow Twitter & Facebook']"));
	            
	            followOnTwitter.click();
	 
	            // To handle parent window
	            String MainWindow = driver.getWindowHandle();
	            System.out.println("Main window handle is " + MainWindow);
	 
	            // To handle child window
	            Set<String> s1 = driver.getWindowHandles();
	            System.out.println("Child window handle is" + s1);
	            Iterator<String> i1 = s1.iterator();
	            while (i1.hasNext()) {
	                String ChildWindow = i1.next();
	                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	                    driver.switchTo().window(ChildWindow);
	                    String pageTitle=driver.getTitle();
	                    System.out.println("The web page title of child window is:"+pageTitle);
	                    driver.close();
	                    System.out.println("Child window closed");
	                }
	            }
	            
	            driver.switchTo().window(MainWindow);
	           System.out.println( followOnTwitter.getText());
	 
	        } catch (Exception e) {
	 
	        }
		
	}

}


