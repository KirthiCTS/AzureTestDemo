package com.TestCases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.testng.annotations.Test;

import com.POM.OrangeHRMSLoginPage;
import com.selenium.BaseClass_TestNG;
import com.utils.*;

public class TC04_TestRunnerUsingExcelData extends BaseClass_TestNG {


	@Test
	public void ReaddataFromXMLPasstoSelenium() throws IOException, InterruptedException {
		ExcelUtils getdata = new ExcelUtils("input_excel.xlsx",0);
		Map<String, Map<String, String>> excelData =getdata.getExcelAsMap();
		String Username = excelData.get("1").get("Username");
		String Password = excelData.get("1").get("Password");
		String url=excelData.get("1").get("Url");
		
		String Username1 = excelData.get("2").get("Username");
		String Password1 = excelData.get("2").get("Password");
		String url1=excelData.get("2").get("Url");
		
		System.out.println(Username);
		System.out.println(Username1);
		System.out.println(Password);
		System.out.println(url);
		System.out.println(url1);
		ChromeOptions co = new ChromeOptions();
		co.setBinary("C:\\Users\\2270103\\OneDrive - Cognizant\\Documents\\selenium binaries\\chrome-win64\\chrome-win64\\chrome.exe");
		co.setBrowserVersion("119");
		co.setBrowserVersion("119");
		String browserPath = SeleniumManager.getInstance().getDriverPath(co, false).getBrowserPath();
		String driverPath = SeleniumManager.getInstance().getDriverPath(co, false).getDriverPath();
		co.setBinary(browserPath);
		
		System.out.println(browserPath);
		System.out.println(driverPath);
		//Uncomment the below code later for demo purposes
		OrangeHRMSLoginPage login = new OrangeHRMSLoginPage(driver);
		login.GetURL(url);
		Thread.sleep(10000);
		login.SetUsername(Username);
		login.SetPassword(Password);
		login.clickLogin();

	}

}
