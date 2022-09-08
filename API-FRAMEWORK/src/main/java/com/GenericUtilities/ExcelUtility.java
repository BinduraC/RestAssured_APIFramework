package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Bindura
 *
 */
public class ExcelUtility {
	
	/**
	 * this method is used to get data from Excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Cell cell = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	/**
	 * this method is used to insert data into Excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);;;
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelpath);
		workbook.write(fos);
		
	}
	
	/**
	 * this method is used to get last row numberof excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getLastRowNumFromExcel(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet= workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
		
	}
}
