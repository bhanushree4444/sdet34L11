package com.vtiger.createProduct;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewProductPage;
import com.Vtiger.ObjectRepository.ProductHomePage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateProductTest extends BaseClass{
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
