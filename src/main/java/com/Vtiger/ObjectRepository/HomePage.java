package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.WebdriverClass;

public class HomePage {
	
	
	@FindBy(xpath ="//a[.='Contacts']")
	private WebElement contacetButton;
	
	@FindBy(xpath ="//a[.='Products']")
	private WebElement productsButton;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutButtom;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement menuDropDown;
	
	@FindBy(name="Campaigns")
	private WebElement campaignLink;
	

	@FindBy(xpath="//a[.='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingsImg;
	
	@FindBy(xpath="//a[.='CRM Settings']")
	private WebElement crmInSettings;
	
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void settingsClickWithCrm(WebDriver driver,WebdriverClass webdriverClass) {
		
		webdriverClass.actionsClassInvoke(driver);
		 webdriverClass.mouseHoverOnTheElement(driver, settingsImg);
		 crmInSettings.click();
	}
	
	public void documentClick() {
		documentLink.click();
	}
	
	public void organizationClick() {
		organizationLink.click();
	}
	
	
	public void contactClick() {
		contacetButton.click();
	}
	
	public void productsClick() {
		productsButton.click();
	}

	public void logoutClick(WebDriver driver,WebdriverClass webdriverClass) {
	webdriverClass.waitTillPageLoad(10,driver);
		webdriverClass.mouseHoverOnTheElement(driver, administratorIcon);
		signoutButtom.click();
	}
	
	public void menuDropDownMouseHOver(WebDriver driver,WebdriverClass webdriverClass) {
		webdriverClass.mouseHoverOnTheElement(driver, menuDropDown);
	}
	public void campaignLinkClick() {
		campaignLink.click();
	}
	
}
