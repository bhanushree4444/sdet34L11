package com.vtiger.createCampaigns;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.ContactInformationPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateContactTest extends BaseClass{
@Test(groups = "sanity")
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
}
