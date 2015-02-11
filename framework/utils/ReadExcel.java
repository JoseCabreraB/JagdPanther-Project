package framework.utils;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private Workbook workbook = null;
	public ReadExcel(String filePath,String fileName) throws Exception{
		File file =    new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file	    
		if(fileExtensionName.equals(".xlsx")) {

			//If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);
		}

		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")) {

			//If it is xls file then create object of XSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);
		}
	}
	public Object[][] readExcelObject(String sheetName) throws IOException{
		Sheet Sheet = workbook.getSheet(sheetName);

		//Find number of rows in excel file
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		Object[][] data = new Object[rowCount + 1][Sheet.getRow(0).getLastCellNum()];

		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = Sheet.getRow(i);

			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				data[i][j] = (row.getCell(j).getStringCellValue());
			}
		}
		return data;
	}
	public List<Map<String,String>> readExcelHowMap(String sheetName) throws IOException{

		Sheet sheet = workbook.getSheet(sheetName);

		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		List<Map<String,String>> data = new LinkedList<>();
		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			Map<String, String> currentRow = new HashMap<String,String>();
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				currentRow.put(sheet.getRow(0).getCell(j).getStringCellValue(),
						row.getCell(j).getStringCellValue());
			}
			data.add(currentRow);
		}
		return data;
	}
}

