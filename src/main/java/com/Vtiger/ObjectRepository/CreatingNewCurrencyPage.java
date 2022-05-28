package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class CreatingNewCurrencyPage {

	

	@FindBy(name="currency_name")
	private WebElement currencyNameDropDown;
	
	
	@FindBy(xpath="//input[@name='conversion_rate']")
	private WebElement conversionRateText;
	
	@FindBy(xpath="//input[@value='Save' and @class='crmButton small save']")
	private WebElement saveButton;

	

	public CreatingNewCurrencyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	public void currencyNameDropDownSelectByValue(String value,WebdriverClass webdriverClass) {
		webdriverClass.selectClassInvoke(currencyNameDropDown);
		 webdriverClass.selectByValue(value);
	}
	public void sendConversionRate(String conversionRate) {
		conversionRateText.sendKeys(conversionRate);
	}
	public void saveButtonClick() {
		saveButton.click();
	}
	
}
