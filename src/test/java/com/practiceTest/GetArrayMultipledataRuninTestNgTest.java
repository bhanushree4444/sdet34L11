package com.practiceTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.IconstantPath;

public class GetArrayMultipledataRuninTestNgTest {
	
@Test(dataProvider="logindata")
public void practiceTNGTest(String username,String password) {
	Reporter.log(username+"   ------->     "+password,true);
}
@DataProvider
public Object[][] logindata() throws EncryptedDocumentException, IOException {
	ExcelData.openExcel(IconstantPath.EXCELPATH);
	return ExcelData.getMultipleDataFromExcelArray("commondata1");
}
}
