package com.Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class OrganizationSearchPage {

	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	
	
    
	public OrganizationSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	
	

	
	public void selectOrganization(String organizationName,WebDriver driver,WebdriverClass webdriverClass) {
		webdriverClass.switchToWindowBasedOnTitle(driver, "Accounts&action");
		searchText.sendKeys(organizationName);
		searchButton.click();
		driver.findElement(By.xpath("//a[.='"+organizationName+"']")).click();
	}
}
