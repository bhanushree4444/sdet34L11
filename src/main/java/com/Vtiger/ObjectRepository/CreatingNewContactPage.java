package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class CreatingNewContactPage {
	
	@FindBy(name ="lastname")
	private WebElement lastNameText;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrganizationIcon;
	
	@FindBy(name="salutationtype")
	private WebElement firstNameDropD;
	
	@FindBy(id="jscal_trigger_birthday")
	private WebElement birthdateImg;
	
	@FindBy(xpath="//td[@class='day selected today']")
	private WebElement birthdateToday;
	
	
	 
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void birthdateTodayClick() {
		birthdateToday.click();
	}
	
	public void birthdateImgClick() {
		birthdateImg.click();
	}
	
	

public void slectOrganizationIconClick() {
	selectOrganizationIcon.click();
}
	
	
	public void sendLastnameAndSave(String lastName) {
	    lastNameText.sendKeys(lastName);
	    saveButton.click();
	    
	}
	
	public void firstNameDropDSelectByValue(String value,WebdriverClass webdriverClass) {
		webdriverClass.selectClassInvoke(firstNameDropD);
		webdriverClass.selectByValue(value);
	}
	
	public void sendLastname(String lastName) {
	    lastNameText.sendKeys(lastName);  
	}
	
	public void saveButtomClick() {
	    saveButton.click();
	    
	}
}
