package com.vtiger.contact;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.Vtiger.ObjectRepository.CreatingNewOrganizationPage;
import com.Vtiger.ObjectRepository.OganizationHomePage;
import com.Vtiger.ObjectRepository.OrganizationInformationPage;
import com.Vtiger.ObjectRepository.OrganizationSearchPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateContactsWithOrgaNameTest extends BaseClass{
	@Test
	public void createContactsWithOrgaNameTest() throws IOException, InterruptedException {
		
	
		String organization= ExcelData.getDataFromExcel("tdOrganization", 3, 1)+randomNumber;
		String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
		
		
	    OganizationHomePage  oganizationHomePage =new OganizationHomePage (driver);
	    CreatingNewOrganizationPage creatingNewOrganization=new CreatingNewOrganizationPage(driver);
	    ContactHmPage contacthomepage=new ContactHmPage(driver);
        CreatingNewContactPage creatingnewcontactpage=new CreatingNewContactPage(driver);	    
        OrganizationSearchPage organizationSearchPage=new OrganizationSearchPage(driver);
        OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
			
			 homepage.organizationClick();
			 oganizationHomePage.organizationIconClick();
			 creatingNewOrganization.organizationNameSend(organization);
			 creatingNewOrganization.saveButtonClick();
			 jutil.assertionThroughCondition(organizationInformationPage.createdOrganizationText(), organization, "Organization");
			 homepage.contactClick();
			 contacthomepage.contactClickicon();
			 creatingnewcontactpage.sendLastname(lastname);
			 creatingnewcontactpage.slectOrganizationIconClick();
			 organizationSearchPage.selectOrganization(organization, driver,webdriverClass);
			 webdriverClass.switchToWindowBasedOnTitle(driver,"Contacts&action");
			creatingNewOrganization.saveButtonClick();
		}
}
