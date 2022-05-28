package com.sdetl1.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this used to maintain all the excel specific common methods
 * @author Madhu
 *
 */

public class ExcelData {
	static FileOutputStream fos;
	static Workbook wb;
	/**
	 * this method used to open the excel
	 */
	
	public static void openExcel(String filepath) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream(filepath);
	    wb = WorkbookFactory.create(fs);
	}
	
	
	
	/**
	 * this method used to fetch data from the excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getDataFromExcel(String sheetName,int rowNum, int cellNum) 
	{
	
	String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return data;
   }
	
	
	/**
	 * this method used to fetch array multiple value from excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcelArray(String sheetName) 
	{
		
		Sheet s = wb.getSheet(sheetName);
	 Object[][] arr = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
		for(int i=0;i<s.getLastRowNum();i++) 
		{
			for(int j=0;j<s.getRow(i).getLastCellNum();j++) 
			{
				arr[i][j]=s.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return arr;
   }
	/**
	 * this method used to fetch numeric  value from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getDataFromExcelNumeric(String sheetName,int rowNum, int cellNum) 
	{
	
	String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	return data;
   }
	/**
	 * this method used to write data into excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param message
	 */
	public static void setDataInExcel(String sheetName,int rowNum, int cellNum,String message) 
	{
	   wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(message);
	
    }
	
	/**
	 * this method used to specify the save file path
	 * @param filepath
	 */
	public static void saveFilePath(String filepath) {
		try {
			 fos=new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method used to save excel data
	 */
	public static void saveExcelData() {
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method used to close excel
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException {
		wb.close();
	}
}
  