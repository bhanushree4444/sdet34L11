package com.Vtiger.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.WebdriverClass;

public class CreatingNewDocumentPage {

	@FindBy(name="notes_title")
	private WebElement titleText;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement frame;
	
	@FindBy(xpath="//body[@class='cke_show_borders' and @spellcheck='false']")
	private WebElement frameText;
	
	@FindBy(xpath="//a[@id='cke_5']")
	private WebElement boldButton;
	
	@FindBy(xpath="//a[@id='cke_6']")
	private WebElement italicButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]' and @name='button' and @value='  Save  ']/../input[1]")
	private WebElement saveButton;
	
	@FindBy(name="filename")
	private WebElement chuseFileButton;
	

	 
	
	    public CreatingNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
 
	    public void sendFile(String filePath) {
	    	chuseFileButton.sendKeys(filePath);
		}
	    
	public void titleSend(String title) {
		titleText.sendKeys(title);
	}
	
	public void sendDataToFrameText(String description,JavaGenericClass jutil) throws InterruptedException {
		jutil.customWait(frameText, 1, 10);
		frameText.sendKeys(description);
	}
	public void sendDataToFrameTextAndSelect(String description,JavaGenericClass jutil) throws InterruptedException {
		
		jutil.customWait(frameText, 1, 10);
		frameText.sendKeys(description,Keys.CONTROL+"a");
	}
	
	public void frameSwitch(WebDriver driver,WebdriverClass webdriverClass) {
		webdriverClass.switchToFrame(driver, frame);
	}
	
	 public void boldButtonClick() {
	    	boldButton.click();
		}
	 public void italicButtonClick() {
	    	italicButton.click();
		}
	 public void saveButtonClick() {
	    	saveButton.click();
		}
	
}
