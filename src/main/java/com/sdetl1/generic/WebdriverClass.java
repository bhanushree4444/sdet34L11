package com.sdetl1.generic;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class is used to maintain all webdriver common actions
 * @author Madhu
 *
 */
public class WebdriverClass {
	static Actions act;
	static WebDriverWait wait ;
	static Select sel;
	static JavascriptExecutor jse;
	static JavaGenericClass jutil=new JavaGenericClass();
	static Alert alert;
/** 
 * this method used to navigate to application
 * @param url
 * @param driver
 */
	public  static void navigateApp(String url,WebDriver driver) {
		driver.get(url);
	}
	
	/**
	 * this method is used to maximize the browser
	 * @param LongTimeOut
	 * @param driver
	 */
	public  void browserSetting(long LongTimeOut,WebDriver driver) {
		maximizeBrowser(driver);
		waitTillPageLoad(LongTimeOut, driver);
		
	}
	
	
	/**
	 * this method used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	
	/**
	 * this method used to implicitly wait till page load
	 * @param LongTimeOut
	 * @param driver
	 */
	public  void waitTillPageLoad(long LongTimeOut,WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(LongTimeOut, TimeUnit.SECONDS);
	}
	/**
	 * this method used to invoke actions class
	 * @param driver
	 */
	
	public void actionsClassInvoke(WebDriver driver) {
		 act=new Actions(driver);
	}
	
	/**
	 * this method used to double click on the WebElement
	 * @param element
	 */
	public  void doubleClick(WebElement element) {
		act.moveToElement(element).doubleClick().perform();
	}
	
	
	/**
	 * this method used to mouse hover on the element
	 * @param driver
	 * @param moveele
	 */	
     public  void mouseHoverOnTheElement(WebDriver driver,WebElement moveEle) {
    	 
    	 act.moveToElement(moveEle).perform();
     }
     
     
     /**
      * this method used to wait the control till the particular element is visible
      * @param element
      */
     public  void waitUntillElementVisible(WebElement element) {
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
     /**
      * this method used to wait the control till the  alert is visible
      */
     public void waitUntillAlertVisible() {
    	 wait.until(ExpectedConditions.alertIsPresent());
     }
     
     
     /**
      * this method used to wait until the element is clickable
      * @param element
      */
     public  void waitUntillElementClickable(WebElement element) {
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     
     
     /**
      * this method is used to initialize the wait instance
      * @param driver
      * @param timeout
      */
     public  void explicitlyWait(WebDriver driver,long timeout) {
    	 wait = new WebDriverWait(driver, timeout);
     }
     
     /**
      * this method used to switch to window based on title
      * @param driver
      * @param partialText
      */
     public  void switchToWindowBasedOnTitle(WebDriver driver,String partialText) {
    	Set<String> sessionId = driver.getWindowHandles();
    	for(String Id:sessionId) {
    		driver.switchTo().window(Id);
    		if(driver.getTitle().contains(partialText)) {
    			break;
    		}
    	}
     }
     public  void selectClassInvoke(WebElement dropdownElement) {
		 sel=new Select(dropdownElement);
		 
	}
	/**
	 * this method used to select by visible text
	 * @param visibletext
	 */
	public  void selectByVisibletext(String visibletext) {
		sel.selectByVisibleText(visibletext);
	}
	/**
	 * this method used to select by index
	 * @param index
	 */
	public  void selectByIndex(int index) {
		sel.selectByIndex(index);
	}
	
	/**
	 * select by value 
	 * @param textValue
	 */
	public  void selectByValue(String textValue) {
		sel.selectByValue(textValue);
	}
	
	/**
	 * this method used to switch to frame based up on id
	 * @param driver
	 * @param numberID
	 */
	public void switchToFrameID(WebDriver driver,String numberID) {
		driver.switchTo().frame(numberID);
	}
	
     /**
      * this method used to switch to frame based on element
      * @param driver
      * @param element
      */
	public  void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method used to switch to frame based up on index
	 * @param driver
	 * @param index
	 */
	public  void switchToFrameIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method used to switch to frame based up on name or id 
	 * @param driver
	 * @param nameOrId
	 */
	public  void switchToFrameIdOrName(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * this method used to switch back to main frame
	 * @param driver
	 */
	public void switchBackToHome(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method used to invoke the java script
	 * @param driver
	 */
	public  void javaScriptExecutorInvoke(WebDriver driver) {
		 jse=(JavascriptExecutor) driver; 
	}
	
/**
 * this method used to enter data thorough java script executer
 * @param element
 * @param data
 */
	public  void enterDatathroughJse(WebElement element,String data) {
		jse.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	
	/**
	 * this method used to click element thorough java script executer
	 * @param element
	 */
	public  void clickThroughJse(WebElement element) {
		jse.executeScript("arguments[0].click", element);
	}
	
	/**
	 * this method used to scroll till bottom java script executer
	 */
	public  void scrollToBottom() {
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * this method used to scroll till element thorough java script executer
	 * @param element
	 */
	public  void scrollTillElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoview()", element);
	}
	
	/**
	 * this method used to naviage to application thorough java script executer
	 * @param url
	 */
	 public  void navigateApplicationThroughjs(String url) {
		 jse.executeScript("window.location=arguments[0]", url);
	 }
	 
	 /**
	  * this method used to scroll till specific height thorough java script executer
	  * @param height
	  */
	 public   void scrollToSpecifiedHeight(String height) {
		 jse.executeScript("window.scrollBy(0,"+height+")");
	 }
	 
	 /**
	  * this method used to get screen shot 
	  * @param fileName
	  * @param driver
	 * @return 
	  * @throws IOException
	  */
	 public   String takeScreenShot(String fileName,WebDriver driver) throws IOException {
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./screenshot/"+fileName+"_"+jutil.dateTimeInFormat()+".png");
		 
		 FileUtils.copyFile(src, dst);
		 return dst.getAbsolutePath();
	 }
	 
	 /**
	  * this method used to switch to alert
	  * @param driver
	  */
	 public     void switchToAlert(WebDriver driver) {
		 alert=driver.switchTo().alert();
		 }
	 
	
	 /**
	  * this method used  to alert  accept	
	  */
	 public   void alertAccept(WebDriver driver) {
		 alert.accept();
	 }
	 
	 /**
	  * this method used  to alertalert dismiss
	  * @param driver
	  */
	 public   void alertDismiss(WebDriver driver) {
		 alert.dismiss();
		 }
	 
	 /**
	  *this method used  to alert alert get text
	  * @param driver
	 * @return 
	  */
	 public   String alertGetText(WebDriver driver) {
		return alert.getText();
		 }
	 
     /**
      * this method used to close the browser instance
      * @param driver
      */
     public   void quitBrowser(WebDriver driver) {
    	 
    	 driver.quit();
     }
}
