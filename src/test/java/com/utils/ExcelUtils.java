package com.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
	//private  String filePath = "input_excel.xlsx";

	private String filePath;
	private int sheetIndex;

	 public ExcelUtils(String filePath, int sheetIndex) {
		
		this.filePath = filePath;
		this.sheetIndex = sheetIndex;
	}

	private XSSFSheet getSheet() throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		return sheet;
	}

	public Map<String, Map<String, String>> getExcelAsMap() throws IOException {
		XSSFSheet sheet = getSheet();
		Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
		List<String> columnHeader = new ArrayList<String>();
		Row row = sheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			columnHeader.add(cellIterator.next().getStringCellValue());
		}
	//	int rowCount = row.getLastCellNum();
		int rowCount = sheet.getLastRowNum();
		int columnCount = row.getLastCellNum();
		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> singleRowData = new HashMap<String, String>();
			Row row1 = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row1.getCell(j);
				singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
			}
			completeSheetData.put(String.valueOf(i), singleRowData);
		}
		return completeSheetData;
	}

	public String getCellValueAsString(Cell cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case FORMULA:
			cellValue = cell.getCellFormula();
		case BLANK:
			cellValue = "BLANK";
		default:
			cellValue = "DEFAULT";
		}
		return cellValue;
	}

}
