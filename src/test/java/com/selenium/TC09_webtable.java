package com.selenium;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC09_webtable extends BaseClass_TestNG{
	
	public static WebDriver driver;
	String browser = "chrome";

	
	//"<table>" - It defines a table. You can also say that it's the starting point of a table.
	//"<th>" - It defines a header cell, which means you should define your headings inside th tag.
	//"<tr>" - It defines a row in a table. 
	//"<td>" - It defines a cell in a table. "td" always lie inside the tr tag.
	
	@Test
	public void StaticWebTable() throws Exception {

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		//Get number of rows In table.
		 int Row_count = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr")).size();
		 System.out.println("Number Of Rows = "+Row_count);

		 //Get number of columns In table.
		 int Col_count = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th")).size();
		 System.out.println("Number Of Columns = "+Col_count);

		
		 //Used for loop for number of rows.
		 for (int i=2; i<=Row_count; i++){
		  
		  //Used for loop for number of columns.
		  for(int j=1; j<=Col_count; j++){
		   
		   //Prepared final xpath of specific cell as per values of i and j.
		   String final_xpath = "//*[@id='customers']/tbody/tr["+i+"]/td["+j+"]";
		   
		   //Will retrieve value from located cell and print It.
		   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
		   System.out.print(Table_data +" ");
		  }

		  System.out.println("");
		  System.out.println("");
		 }
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();

	}
	
	@Test
	public void test_Dynamic_Webtable() {
	
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
	  // Locate table
	  WebElement mytable = driver.findElement(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody"));

	  // Locate rows of table and save locators of each row in a list
	  List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

	  // Get no. of rows in table
	  int rows_count = rows_table.size();

	  // Loop will execute till the last row of table
	  for (WebElement row : rows_table) {
	        List<WebElement> cols = row.findElements(By.tagName("td"));
	        for (WebElement col : cols) {
	            System.out.print(col.getText() + "\t");
	        }
	        System.out.println();
	    }
	}
	
	@Test
	public void guru99webtable() {
		
		 driver.get("https://demo.guru99.com/test/web-table-element.php"); 
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = driver.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//tbody/tr[3]"));
         String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//tbody/tr[3]/td[2]"));
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
		    driver.close();
		
	}

}
