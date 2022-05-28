package com.vtiger.documents;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewDocumentPage;
import com.Vtiger.ObjectRepository.DocumentHomePage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateDocumentsTest extends BaseClass{
	@Test
	public void documentsTest() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		String title= ExcelData.getDataFromExcel("document", 1, 0)+randomNumber;
		String path= ExcelData.getDataFromExcel("document", 1, 2);
		String  description= ExcelData.getDataFromExcel("commondata", 17, 0);
   
    DocumentHomePage documentHomePage=new DocumentHomePage(driver);
    CreatingNewDocumentPage creatingNewDocumentPage=new CreatingNewDocumentPage(driver);
    
    homepage.documentClick();
    documentHomePage.documentIconClick();
    creatingNewDocumentPage.titleSend(title);
    creatingNewDocumentPage.frameSwitch(driver,webdriverClass);
    creatingNewDocumentPage.sendDataToFrameTextAndSelect(description,jutil);
    webdriverClass.switchBackToHome(driver);
    creatingNewDocumentPage.boldButtonClick();
    creatingNewDocumentPage.italicButtonClick();
    creatingNewDocumentPage.sendFile(path);
    creatingNewDocumentPage.saveButtonClick();    
}
}