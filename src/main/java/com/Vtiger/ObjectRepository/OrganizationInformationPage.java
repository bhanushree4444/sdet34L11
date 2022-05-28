package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	@FindBy(xpath ="//span[@id='dtlview_Organization Name']")
	private WebElement organizationInformation;
	
 
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	
	public String createdOrganizationText() {
		return organizationInformation.getText();
}
}
