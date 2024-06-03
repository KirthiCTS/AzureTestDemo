package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public void ReadDataFromExcel(String ExcelPath) {
		// Try block to check for exceptions
		try {

			// Reading file from local directory
			FileInputStream file = new FileInputStream(new File(ExcelPath));

			// Create Workbook instance holding reference to
			// .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			// Till there is an element condition holds true
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				// For each row, iterate through all the
				// columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// Checking the cell type and format
					// accordingly
					switch (cell.getCellType()) {

					// Case 1
					case NUMERIC:
						//int i=(int) cell.getNumericCellValue();
						System.out.print((int)cell.getNumericCellValue() + "  ");
						break;

					// Case 2
					case STRING:
						System.out.print(cell.getStringCellValue() + "  ");
						break;
					}
				}

				System.out.println("");
			}

			// Closing file output streams
			file.close();
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display the exception along with line number
			// using printStackTrace() method
			e.printStackTrace();
		}
		
		
	}
	
	
	/*
	 * public static void main(String[] args) { ReadData readData = new ReadData();
	 * readData.ReadDataFromExcel("Sample1.xlsx"); }
	 */
}
