package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrenciesInSettingPage {

	
	@FindBy(xpath="//input[@value='New Currency']")
	private WebElement newCurrencyButton;
	
	

	public CurrenciesInSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	public void newCurrencyButtonClick() {
		
		newCurrencyButton.click();
	}
	
}
