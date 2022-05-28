package com.Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class ProductsSearchPage {

	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	
	
    
	public ProductsSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
 
	
	
	public void productNameSend(String productName) {
		searchText.sendKeys(productName);
	}
	
	public void searchButtonClick() {
		searchButton.click();
	}
	
	public void selectProduct(String productName,WebDriver driver,WebdriverClass webdriverClass) {
		webdriverClass.switchToWindowBasedOnTitle(driver, "Products");
		searchText.sendKeys(productName);

		searchButton.click();
		driver.findElement(By.xpath("//a[.='"+productName+"']")).click();
	}
	
}
