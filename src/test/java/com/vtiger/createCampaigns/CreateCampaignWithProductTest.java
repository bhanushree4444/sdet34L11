package com.vtiger.createCampaigns;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CampaignsHomePage;
import com.Vtiger.ObjectRepository.CreatingNewCampaignPage;
import com.Vtiger.ObjectRepository.CreatingNewProductPage;
import com.Vtiger.ObjectRepository.ProductHomePage;
import com.Vtiger.ObjectRepository.ProductInformationPage;
import com.Vtiger.ObjectRepository.ProductsSearchPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.WebdriverClass;

public class CreateCampaignWithProductTest extends BaseClass {
	@Test
	public void createCampaignwithProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
	
		String productname= ExcelData.getDataFromExcel("product", 0, 1)+randomNumber;
		String campaign= ExcelData.getDataFromExcel("tdCampaign", 0, 1)+randomNumber;
   
    ProductHomePage producthomepage=new ProductHomePage(driver);
    CreatingNewProductPage creatingNewProduct=new CreatingNewProductPage(driver);
    ProductInformationPage productInformationPage=new ProductInformationPage(driver);
    CampaignsHomePage campaignsHomePage=new CampaignsHomePage(driver);
    CreatingNewCampaignPage creatingNewCampaign=new CreatingNewCampaignPage(driver);
    ProductsSearchPage productsSearchPage=new ProductsSearchPage(driver);
  
    homepage.productsClick();
	producthomepage.productIconClick();
	creatingNewProduct.sendProductName(productname);
	creatingNewProduct.saveButtonClick();
	 jutil.assertionThroughConditionContains(productInformationPage.getproductNameText(), productname,"product name  ");
	homepage.menuDropDownMouseHOver(driver,webdriverClass);
	homepage.campaignLinkClick();
	campaignsHomePage.campaignIconClick();
	creatingNewCampaign.campaignNameSend(campaign);
	creatingNewCampaign.productSelectIconClick();
	 webdriverClass.switchToWindowBasedOnTitle(driver,campaign);
	productsSearchPage.selectProduct(productname, driver,webdriverClass);
    webdriverClass.switchToWindowBasedOnTitle(driver,"Campaigns&action");
    creatingNewCampaign.saveButtonClick();
	}
	}
	

