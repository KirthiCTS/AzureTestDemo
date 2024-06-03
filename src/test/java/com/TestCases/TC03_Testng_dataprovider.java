package com.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.BaseClass_TestNG;

public class TC03_Testng_dataprovider extends BaseClass_TestNG{
	

	@Test (dataProvider = "loginmethod",  dataProviderClass = BaseClass_TestNG.class)
	public void login(String username , String pwd) throws Exception {
			
		try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
     	
	}
	

}
