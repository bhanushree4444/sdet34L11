package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewGroupInSettingsPage {

	
	@FindBy(name="groupName")
	private WebElement groupNameText;
	
	@FindBy(name="add")
	private WebElement addGroupButton;
	
	@FindBy(xpath="//option[.='Group::Team Selling']")
	private WebElement memberOfEntityinGroup;
	
	@FindBy(xpath="//input[@onclick='addColumn()']")
	private WebElement addButton;
	
	 

	public CreateNewGroupInSettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
public void addButtonClick() {
		
	addButton.click();
	}
public void selectmMemberOfEntityInGroup() {
	
	memberOfEntityinGroup.click();
	} 

	public void groupNameSend(String groupName) {
		
		groupNameText.sendKeys(groupName);
	}
public void addGroupButtonClick() {
		
	addGroupButton.click();
	}
}
