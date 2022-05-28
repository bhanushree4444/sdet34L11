package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	@FindBy(name ="productname")
	private WebElement productNameTxt;
	
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void sendProductName(String productName) {
		productNameTxt.sendKeys(productName);
	}
	
	public void saveButtonClick() {
		
		saveButton.click();
	}
}
