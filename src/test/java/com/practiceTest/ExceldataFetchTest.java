package com.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExceldataFetchTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("contacts");
		Row rw = sh.getRow(0);
		Cell cl = rw.getCell(1);
		Random r = new Random();
		int ran = r.nextInt();
		String data = cl.getStringCellValue();
		System.out.println(data+ran);
		
	}

}
