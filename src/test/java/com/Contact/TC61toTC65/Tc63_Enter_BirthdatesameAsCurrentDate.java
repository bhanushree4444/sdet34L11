package com.Contact.TC61toTC65;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.WebdriverClass;

public class Tc63_Enter_BirthdatesameAsCurrentDate extends BaseClass {
@Test
	public void tc63_Enter_birthdatesameAsCurrentDate()  {
		String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
	
	    ContactHmPage contactHomePage=new ContactHmPage(driver);
	    CreatingNewContactPage creatingNewContactPage=new CreatingNewContactPage(driver);

			 homepage.contactClick();
			 contactHomePage.contactClickicon();

			 creatingNewContactPage.sendLastname(lastname);
			 creatingNewContactPage.birthdateImgClick();
			 
			 creatingNewContactPage.birthdateTodayClick();
			creatingNewContactPage.saveButtomClick();
			
			webdriverClass.switchToAlert(driver);
	 jutil.assertionThroughConditionContains(webdriverClass.alertGetText(driver), "Birthdate should be less than Current Date", " Birthdate should be less than Current Date message");
		webdriverClass.alertAccept(driver);
			 

	}

}
