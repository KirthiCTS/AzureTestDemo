package com.TestCases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.utils.ExcelUtils;

public class ExcelReader {


		
		@Test
		public void ReaddataFromXMLPasstoSelenium() throws IOException {
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
			System.out.println(Password1);
			System.out.println(url);
			System.out.println(url1);
	}

}
