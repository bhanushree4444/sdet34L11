package com.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement userNameText;
	
	@FindBy(name="user_password")
	private WebElement passWordText;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	/**
	 * business library
	 * @param username
	 * @param password
	 */
public void loginAction(String username,String password) {
	userNameText.sendKeys(username);
	passWordText.sendKeys(password);
	loginButton.click();
}
}
