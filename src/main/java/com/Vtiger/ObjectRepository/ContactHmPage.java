package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHmPage {
	@FindBy(xpath ="//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']")
	private WebElement createcontactlinkicon;
	
	
	
	@FindBy(name ="search_text")
	private WebElement searchText;
	
	@FindBy(name ="submit")
	private WebElement searchButton;
	
	@FindBy(xpath ="//span[@class='genHeaderSmall']")
	private WebElement noContactFoundIcon;
	
 
	
	public ContactHmPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void contactClickicon() {
		createcontactlinkicon.click();
	}
	public void searchTextSendText(String contactName) {
		searchText.sendKeys(contactName);
	}
	
	public String getNoContactFoundIconText() {
	return	noContactFoundIcon.getText();
	}
	
	public void searchButtonClick() {
	searchButton.click();
	}
}
