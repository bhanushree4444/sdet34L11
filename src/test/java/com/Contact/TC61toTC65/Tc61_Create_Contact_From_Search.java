package com.Contact.TC61toTC65;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.ContactInformationPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class Tc61_Create_Contact_From_Search extends BaseClass {
	 
	@Test
	public void tc61_Create_Contact_From_SearchTest() throws IOException, InterruptedException {
	    ContactHmPage contactHmPage=new ContactHmPage(driver);
	    CreatingNewContactPage creatingnewcontactpage=new CreatingNewContactPage(driver);
	    ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
	    String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
		String	 contactname = ExcelData.getDataFromExcel("contacts", 1, 1)+randomNumber;
			 homepage.contactClick();
			 contactHmPage.searchTextSendText(contactname);
			 contactHmPage.searchButtonClick();
			String actual = contactHmPage.getNoContactFoundIconText();
			 jutil.assertionThroughCondition(actual,"No Contact Found !", "contact not ");
			 contactHmPage.contactClickicon();
			 creatingnewcontactpage.sendLastnameAndSave(lastname);
			 
			 jutil.assertionThroughConditionContains(contactInformationPage.createdContactInformationText(), lastname,"contact now");
	}
}
