package com.Contact.TC61toTC65;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;

public class Tc62_Salutation_From_Search extends BaseClass {
@Test
	public  void Tc62_Salutation_From_SearchTest()  {
	    ContactHmPage contactHomePage=new ContactHmPage(driver);
	    CreatingNewContactPage creatingNewContactPage=new CreatingNewContactPage(driver);
			 homepage.contactClick();
			 contactHomePage.contactClickicon();
			 creatingNewContactPage.firstNameDropDSelectByValue("Mrs.",webdriverClass);
	}

}
