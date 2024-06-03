package com.excel;

import java.io.IOException;

public class TestExcel {
	public static void main(String[] args) throws IOException {
		
	//	WriteData writeData = new WriteData();
	//	writeData.WriteDataInExcel();
		//writeData.UpdateExistingFile("Sample2.xlsx");
		
		
		ReadData readData = new ReadData();
		readData.ReadDataFromExcel("Sample1.xlsx");
		
		
	}

}
