package com.vtiger.contact;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.ContactInformationPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class CreateContacttTest  extends BaseClass{
	
	@Test(groups = "sanity")
	 public  void createContacttTest() {
		String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
		
		ContactHmPage contactHomePage=new ContactHmPage(driver);
		CreatingNewContactPage   creatingNewContactPage=new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
	 homepage.contactClick();
	 contactHomePage.contactClickicon();
	 //Assert.fail();
	 creatingNewContactPage.sendLastname(lastname);
	 creatingNewContactPage.saveButtomClick();
	 jutil.assertionThroughConditionContains(contactInformationPage.createdContactInformationText(), lastname,"contact  ");
}

}
