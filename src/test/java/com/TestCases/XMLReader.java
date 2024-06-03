package com.TestCases;

import org.testng.annotations.Test;

import com.POM.OrangeHRMSLoginPage;
import com.utils.GetDataFromXml;

public class XMLReader {


	@Test
	public void ReaddataFromXMLPasstoSelenium() {
		
		GetDataFromXml getdata = new GetDataFromXml();
		String Username = getdata.getXMLData("username");
		String Password = getdata.getXMLData("password");
		String url=getdata.getXMLData("url");
		
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(url);
	}

}
