package com.practiceTest;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.IconstantPath;
import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.PropertyFile;
import com.sdetl1.generic.WebdriverClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchUsingGenericExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		JavaGenericClass jutil=new JavaGenericClass();
		ExcelData.openExcel(IconstantPath.EXCELPATH);
		String url = ExcelData.getDataFromExcel("commondata", 3, 1);
		String username = ExcelData.getDataFromExcel("commondata", 4, 1);
		String password = ExcelData.getDataFromExcel("commondata", 5, 1);
		String browser = ExcelData.getDataFromExcel("commondata", 6, 1);
		String productname= ExcelData.getDataFromExcel("product", 0, 1);
		String campaign= ExcelData.getDataFromExcel("tdCampaign", 0, 1);
		
		PropertyFile.open_property_file(IconstantPath.PROPERTYFILEPATH);
		String timeout = PropertyFile.get_data_propertyfile("timeout");
		
		long timeout1 = jutil.stringToLong(timeout);
		int ran = jutil.getRandomNumber(1000);
		

		WebDriver driver=null;
		
	    switch(browser) {
	    case"chrome":
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    	break;
	    case"firefox":
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	break;
	    default:
	    		System.out.println("please speccify the browser");
	    		WebDriverManager.firefoxdriver().setup();
	    		driver=new FirefoxDriver();
	    }
	    WebdriverClass webdriverClass=new WebdriverClass();
	    webdriverClass.navigateApp(url, driver);
	    webdriverClass.browserSetting(timeout1, driver);
	    
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//a[.='Products']")).click();
		WebElement elee = driver.findElement(By.xpath("//a[.='Products' and @class='hdrLink']"));
		
		
		if(elee.getText().contains("Products")) 
	    {
	    	
	    	System.out.println("product page displayed");
	    	
	    }
		
		
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
	    
	    
	    
	    WebElement actualProductName = driver.findElement(By.id("dtlview_Product Name"));
		
		if(actualProductName.getText().equalsIgnoreCase(productname)) {
			System.out.println("product is created");
			System.out.println("tc pass");
			
			
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		webdriverClass.mouseHoverOnTheElement(driver, ele);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaign);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String Idparent = driver.getWindowHandle();
	    System.out.println(Idparent);
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		for(String id:allid)
			{
			
				driver.switchTo().window(id);
				if(driver.getTitle().contains("Products&action")) {
					break;
				}
			}
	   
		driver.findElement(By.name("search_text")).sendKeys(productname+ran);
		driver.findElement(By.name("search")).click();
	    driver.findElement(By.id("1")).click();
	    Set<String> allid2 = driver.getWindowHandles();
	    for(String id:allid2)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Campaigns&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'and @class='crmButton small save']")).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriverClass.mouseHoverOnTheElement(driver, ele1);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		webdriverClass.quitBrowser(driver);
	}

}
