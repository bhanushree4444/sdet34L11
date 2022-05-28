package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class CreatingNewOrganizationPage {

	
	@FindBy(name ="accountname")
	private WebElement organizationNameText;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name ="industry")
	private WebElement dropDownIndustry;
	
	@FindBy(name ="accounttype")
	private WebElement typeAccount;

	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void typeAccountSelectByValue(String value,WebdriverClass webdriverClass) {
		webdriverClass.selectClassInvoke(typeAccount);
	    webdriverClass.selectByValue(value);
	}
	
	public void dropDownIndustrySelectByValue(String value,WebdriverClass webdriverClass) {
		webdriverClass.selectClassInvoke(dropDownIndustry);
	    webdriverClass.selectByValue(value);
	}
	
	public void organizationNameSend(String orgaNizationName) {
		organizationNameText.sendKeys(orgaNizationName);
	}
	
	public void saveButtonClick() {
		saveButton.click();
	}
	
}
