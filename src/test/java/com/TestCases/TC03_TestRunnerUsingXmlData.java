package com.TestCases;

import org.testng.annotations.Test;

import com.POM.OrangeHRMSLoginPage;
import com.selenium.BaseClass_TestNG;
import com.utils.*;

public class TC03_TestRunnerUsingXmlData extends BaseClass_TestNG {

	

	@Test
	public void ReaddataFromXMLPasstoSelenium() throws InterruptedException {
		
		GetDataFromXml getdata = new GetDataFromXml();
		String Username = getdata.getXMLData("username");
		String Password = getdata.getXMLData("password");
		String url=getdata.getXMLData("url");
		
		OrangeHRMSLoginPage login = new OrangeHRMSLoginPage(driver);
		login.GetURL(url);
		Thread.sleep(10000);
		login.SetUsername(Username);
		login.SetPassword(Password);
		login.clickLogin();

	}

}
