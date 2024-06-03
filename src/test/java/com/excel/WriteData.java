package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	public void  WriteDataInExcel() {
		
		
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Creating a blank Excel sheet
		XSSFSheet sheet = workbook.createSheet("student Details");

		// Creating an empty TreeMap of string and Object][]
		// type
		Map<String, Object[]> data = new TreeMap<String, Object[]>();

		// Writing data to Object[] using put() method
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Pankaj", "Kumar" });
		data.put("3", new Object[] { 2, "Prakashni", "Yadav" });
		data.put("4", new Object[] { 3, "Ayan", "Mondal" });
		data.put("5", new Object[] { 4, "Virat", "kohli" });

		// Iterating over data and writing it to sheet
		Set<String> keyset = data.keySet();

		int rownum = 0;

		for (String key : keyset) {

			// Creating a new row in the sheet
			Row row = sheet.createRow(rownum++);

			Object[] objArr = data.get(key);

			int cellnum = 0;

			for (Object obj : objArr) {

				// This line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String)
					cell.setCellValue((String) obj);

				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}


		try {

			// Writing the workbook
			FileOutputStream out = new FileOutputStream(new File("Sample1.xlsx"));
			workbook.write(out);

			// Closing file output connections
			out.close();
			System.out.println("Data written successfully ");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void UpdateExistingFile(String FILE_NAME) throws IOException {
		InputStream inp = new FileInputStream(FILE_NAME);
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);

	    int num = sheet.getLastRowNum();
	    Row row = sheet.createRow(++num);
	   // row.createCell(0).setCellValue("xyz");
	    
	    Object[] objArr = { "6", "Rahul", "Sharma" };

		int cellnum = 0;

		for (Object obj : objArr) {

			// This line creates a cell in the next column of that row
			Cell cell = row.createCell(cellnum++);

			if (obj instanceof String)
				cell.setCellValue((String) obj);

			else if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
		}
	    

	    // Now it will write the output to a file
	    FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
	    wb.write(fileOut);

	    // Closing the file connections
	    fileOut.close();
	    System.out.println("Data updated successfully ");
		
	}
	/*
	 * public static void main(String[] args) throws IOException { WriteData
	 * writeData = new WriteData(); //writeData.WriteDataInExcel();
	 * writeData.UpdateExistingFile("Sample2.xlsx"); }
	 */

}
