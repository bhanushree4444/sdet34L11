package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentHomePage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement documentIcon;

	
	public DocumentHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	public void documentIconClick() {
		documentIcon.click();
	}
}
