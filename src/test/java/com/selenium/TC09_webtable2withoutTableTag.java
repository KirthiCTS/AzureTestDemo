package com.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC09_webtable2withoutTableTag extends BaseClass_TestNG {

	
	@Test
	public void NonTableTagWebTable() throws Exception {
			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
    	driver.findElement(By.linkText("PIM")).click();
    	
    	// Wait till web table is loaded
    	((JavascriptExecutor)driver).executeScript("scroll(0,800)");
    	
    //	WebDriverWait wait = new WebDriverWait(driver, 20);
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div")));
	
    	// Let's get header first
    	String headerLoc = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div";
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		System.out.println("Headers are:-");
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			System.out.println(headerName);
		}
		
		
		
		
				// Get total rows count excluding headers
				String rowLoc = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div";
				List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
				// Starting from 1 as xpath index starts from 1
				for (int i = 1; i <= allRowsEle.size(); i++) {
					// Getting specific row with each iteration
					String specificRowLoc = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div["+i+"]";
					// Locating only cells of specific row.
					List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
							.findElements(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div"));
					String cellValue = null;
					String cellValue1 = null;
					// Iterating each cell
					for (int j = 1; j < allColumnsEle.size()-1; j++) {
						// Getting cell value
						 cellValue = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div["+i+"]/div/div["+j+"]")).getText();
						
						 cellValue1=cellValue1 + " " + cellValue ;
						
						
					}
					System.out.println(cellValue1);
					
					System.out.println(" ");
				}
		

	
	}
}
