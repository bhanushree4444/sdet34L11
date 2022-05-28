package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupsInSettingsPage {

	@FindBy(name="New")
	private WebElement newGroupButton;
	
	

	public GroupsInSettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	public void newGroupButtonClick() {
		
		 newGroupButton.click();
	}
	
}
