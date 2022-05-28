package com.PracticeOld;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.ContactHmPage;
import com.Vtiger.ObjectRepository.CreatingNewContactPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class Tc61_Create_Contact_From_Search extends BaseClass {
	 
	@Test
	public void tc61_Create_Contact_From_SearchTest() throws IOException, InterruptedException {
	//public static void main(String[] args) throws IOException, InterruptedException {
		
	
	    ContactHmPage contactHmPage=new ContactHmPage(driver);
	    CreatingNewContactPage creatingnewcontactpage=new CreatingNewContactPage(driver);
	    String lastname= ExcelData.getDataFromExcel("contacts", 0, 1)+randomNumber;
	   
		String	 contactname = ExcelData.getDataFromExcel("contacts", 1, 1)+randomNumber;
			 homepage.contactClick();
			 contactHmPage.searchTextSendText(contactname);
			 contactHmPage.searchButtonClick();
			 
			String actual = contactHmPage.getNoContactFoundIconText();
			 jutil.assertionThroughCondition(actual,"No Contact Found !", "contact not ");
			 contactHmPage.contactClickicon();
			 
			 creatingnewcontactpage.sendLastnameAndSave(lastname);
			
			 
			 String actual1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 Thread.sleep(3000);
			 jutil.assertionThroughConditionContains(actual1, lastname,"contact now");
			 
//			 WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//			 
//			 WebdriverClass.mouseHoverOnTheElement(driver, ele1);
//			 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			//WebdriverClass.quitBrowser(driver);
			 
	}

	
	
}
