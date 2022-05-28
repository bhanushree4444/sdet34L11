package com.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetMultipleadataFormExcelArray {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet s = wb.getSheet("commondata1");
 Object[][] arr = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
	for(int i=0;i<s.getLastRowNum();i++) 
	{
		for(int j=0;j<s.getRow(i).getLastCellNum();j++) 
		{
			arr[i][j]=s.getRow(i).getCell(j).getStringCellValue();
			System.out.println(arr[i][j]);
		}
	}
	

	}
}
