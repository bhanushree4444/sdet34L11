package com.vtiger.Organization;


	

	import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewOrganizationPage;
import com.Vtiger.ObjectRepository.OganizationHomePage;
import com.Vtiger.ObjectRepository.OrganizationInformationPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

	public class CreateOrganizationTest extends BaseClass{
		@Test
		public void createOrganizationTest() throws IOException {
			
		String organization= ExcelData.getDataFromExcel("tdOrganization", 3, 1)+randomNumber;
	 
	    OganizationHomePage  organizationHomePage =new OganizationHomePage (driver);
	    CreatingNewOrganizationPage creatingNewOrganization=new CreatingNewOrganizationPage(driver);
	    OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
			homepage.organizationClick();
			organizationHomePage.organizationIconClick();
			creatingNewOrganization.organizationNameSend(organization);
			creatingNewOrganization.saveButtonClick();
			jutil.assertionThroughCondition(organizationInformationPage.createdOrganizationText(), organization, "Organization  ");
		}
	}


