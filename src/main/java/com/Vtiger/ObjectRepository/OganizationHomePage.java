package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationHomePage {

	

	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationLinkicon;
	

	
	public OganizationHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	
	public void organizationIconClick() {
		organizationLinkicon.click();
	}
	
}
