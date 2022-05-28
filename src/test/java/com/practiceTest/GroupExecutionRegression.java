package com.practiceTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.ContactInformationPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.Vtiger.ObjectRepository.CreatingNewProductPage;
import com.Vtiger.ObjectRepository.ProductHomePage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class GroupExecutionRegression extends BaseClass {
	@Test(groups = "regression")
	 public void createContactPomTest() throws IOException {
	String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
	
			
			ContactHmPage contctHpage=new ContactHmPage(driver);
			CreatingNewContactPage CreatingNewContactPage =new CreatingNewContactPage(driver);
			ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		 homepage.contactClick();
		 contctHpage.contactClickicon();
		 CreatingNewContactPage.sendLastnameAndSave(lastname);
		 jutil.assertionThroughConditionContains(contactInformationPage.createdContactInformationText(), lastname, "contact name");
	 }
	
	@Test(groups = {"sanity","regression"})
	public void createProductPropTest() throws IOException {
	
		String productname= ExcelData.getDataFromExcel("product", 0, 1)+randomNumber;
	    
	    ProductHomePage producthomepage=new ProductHomePage(driver);
	    CreatingNewProductPage creatingNewProduct=new CreatingNewProductPage(driver);
		homepage.productsClick();
		 producthomepage.productIconClick();
		 creatingNewProduct.sendProductName(productname);
		 creatingNewProduct.saveButtonClick();
	}

}
