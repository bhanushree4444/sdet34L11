package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	
	@FindBy(xpath="//a[@href='index.php?module=Settings&action=listgroups&parenttab=Settings']")
	private WebElement groupsInSettings;
	
	@FindBy(xpath="//a[@href='index.php?module=Settings&action=CurrencyListView&parenttab=Settings']")
	private WebElement currencyInSettings;
	
	
	public SettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	public void currencyInSettingsClick() {
		
		currencyInSettings.click();
	}
	
	public void groupsInSettingsClick() {
		
		 groupsInSettings.click();
	}
	
	
}
