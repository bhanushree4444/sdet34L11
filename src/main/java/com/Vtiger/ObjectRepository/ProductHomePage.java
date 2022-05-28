package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {
	@FindBy(xpath ="//img[@title='Create Product...']")
	private WebElement createproductclinkicon;
	
	

	public ProductHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void productIconClick() {
		createproductclinkicon.click();
	}
	

}
