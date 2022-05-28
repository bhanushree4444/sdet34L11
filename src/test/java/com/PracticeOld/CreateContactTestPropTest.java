package com.PracticeOld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

	public class CreateContactTestPropTest extends BaseClass {
		ContactHmPage contactHomePage;
		   CreatingNewContactPage creatingNewContactPage;
		
		@Test
		 public  void createContactTestPropTest() {
			String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
			
			contactHomePage=new ContactHmPage(driver);
		     creatingNewContactPage=new CreatingNewContactPage(driver);
		 homepage.contactClick();
		 contactHomePage.contactClickicon();
		 creatingNewContactPage.sendLastname(lastname);
		 creatingNewContactPage.saveButtomClick();
		 WebElement ele = driver.findElement(By.id("dtlview_Last Name"));
		 boolean p = ele.isDisplayed();
		 if(p)
		 {
			jutil.printStatement("element displayed");
		 }
		 else
		 {
			 jutil.printStatement("Element is not display");
		 }
		 Reporter.log("contact created",true);
		 
	}

	}

