package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	
	

	@FindBy(name="campaignname")
	private WebElement campaignNameText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productSelectIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'and @class='crmButton small save']")
	private WebElement saveButton;
	

	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	
	
	public void campaignNameSend(String campaignName) {
		campaignNameText.sendKeys(campaignName);
	}
	
	public void productSelectIconClick() {
		productSelectIcon.click();
	}
	public void saveButtonClick() {
		saveButton.click();
	}
	
}
