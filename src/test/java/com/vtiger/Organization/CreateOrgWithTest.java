package com.vtiger.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewOrganizationPage;
import com.Vtiger.ObjectRepository.OganizationHomePage;
import com.Vtiger.ObjectRepository.OrganizationInformationPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateOrgWithTest extends BaseClass{
@Test
	public void createOrgWithDdTest() throws EncryptedDocumentException, IOException, InterruptedException {
	
		String organization= ExcelData.getDataFromExcel("tdorganization", 3, 1)+randomNumber;
	
	
	    OganizationHomePage  organizationHomePage =new OganizationHomePage (driver);
	    CreatingNewOrganizationPage creatingNewOrganization=new CreatingNewOrganizationPage(driver);
	    OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
	    
			homepage.organizationClick();
		organizationHomePage.organizationIconClick();
	    creatingNewOrganization.organizationNameSend(organization);
	    creatingNewOrganization.dropDownIndustrySelectByValue("Education",webdriverClass);
	    creatingNewOrganization.typeAccountSelectByValue("Press",webdriverClass);
	    creatingNewOrganization.saveButtonClick();
	    
	    
	    webdriverClass.explicitlyWait(driver, timeout);
	    jutil.assertionThroughCondition(organizationInformationPage.createdOrganizationText(), organization, "Organization  ");

	}
}
