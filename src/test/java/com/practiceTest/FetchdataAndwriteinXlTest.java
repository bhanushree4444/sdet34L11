package com.practiceTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.IconstantPath;
import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.PropertyFile;
import com.sdetl1.generic.WebdriverClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchdataAndwriteinXlTest {
		public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
		
		{
			JavaGenericClass jutil=new JavaGenericClass();
		int ranNo = jutil.getRandomNumber(1000);
		ExcelData.openExcel(IconstantPath.EXCELPATH);
		
		String url = ExcelData.getDataFromExcel("commondata", 3, 1);
		String username = ExcelData.getDataFromExcel("commondata", 4, 1);
		String password = ExcelData.getDataFromExcel("commondata", 5, 1);
		String browser = ExcelData.getDataFromExcel("commondata", 6, 1);
		String productname= ExcelData.getDataFromExcel("product", 0, 1)+ranNo;
		String campaign= ExcelData.getDataFromExcel("tdCampaign", 0, 1)+ranNo;
		
		PropertyFile.open_property_file(IconstantPath.PROPERTYFILEPATH);
		String timeout = PropertyFile.get_data_propertyfile("timeout");
		
		long timeout1 = jutil.stringToLong(timeout);
		//int ran = jutil.getRandomNumber(1000);
		

		
		
	    WebDriver driver=null;
	    switch(browser) 
	    {
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
	
	    webdriverClass.actionsClassInvoke(driver);
	    
	    //test case step1
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    jutil.assertionThroughCondition(driver.getTitle(), "Home", "home page");
	    ExcelData.saveFilePath(IconstantPath.EXCELPATH);
	    ExcelData.setDataInExcel("commondata", 11, 5, "home page");
	    webdriverClass.takeScreenShot("Vtiger Home Page", driver);
	    
	    if(driver.getTitle().contains("Home")) 
	    {
	    	//wb.getSheet("commondata").getRow(11).createCell(5).setCellValue("home page  displayed");
	    	//wb.getSheet("commondata").getRow(11).createCell(6).setCellValue("pass");
	    }
	    
	    //test case step2
		driver.findElement(By.xpath("//a[.='Products']")).click();
		WebElement elee = driver.findElement(By.xpath("//a[.='Products' and @class='hdrLink']"));
		
		jutil.assertionThroughCondition(elee.getText(), "Products", "Products");
		if(elee.getText().contains("Products")) 
	    {
	    	//wb.getSheet("commondata").getRow(12).createCell(5).setCellValue("product page  displayed");
	    	System.out.println("entere the data");
	    	//wb.getSheet("commondata").getRow(12).createCell(6).setCellValue("pass");
	    }
		
		 ExcelData.setDataInExcel("commondata", 11, 6, "pass");
		 ExcelData.setDataInExcel("commondata", 12, 5, "home page");
		 ExcelData.setDataInExcel("commondata", 12, 6, "pass");
		
		 
		 
		 
		 
		 
		 
		 
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement actualProductName = driver.findElement(By.id("dtlview_Product Name"));
		
		if(actualProductName.getText().equalsIgnoreCase(productname)) {
			System.out.println("product is created");
			System.out.println("tc pass");
			//wb.getSheet("commondata").getRow(13).createCell(5).setCellValue("product page  displayed");
	    	
	    	//wb.getSheet("commondata").getRow(13).createCell(6).setCellValue("pass");
			
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		
		WebDriverWait wait=new WebDriverWait(driver, timeout1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		webdriverClass.mouseHoverOnTheElement(driver, ele);
		
		/*
		 * Actions act=new Actions(driver); act.moveToElement(ele).perform();
		 */
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaign);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		webdriverClass.switchToWindowBasedOnTitle(driver, "Products&action");
		/*
		 * String Idparent = driver.getWindowHandle(); 
		 * System.out.println(Idparent);
		 * Set<String> allid = driver.getWindowHandles();
		 *  System.out.println(allid);
		 * for(String id:allid) {
		 * 
		 * driver.switchTo().window(id);
		 * if(driver.getTitle().contains("Products&action")) {
		 *  break; } }
		 */
		/*
		 * Random r=new Random(); int random = r.nextInt(1000);
		 */
		driver.findElement(By.name("search_text")).sendKeys(productname+ranNo);
		driver.findElement(By.name("search")).click();
	    driver.findElement(By.id("1")).click();
	    webdriverClass.switchToWindowBasedOnTitle(driver,"Campaigns&action" );
		/*
		 * Set<String> allid2 = driver.getWindowHandles(); 
		 * for(String id:allid2) {
		 * driver.switchTo().window(id);
		 * if(driver.getTitle().contains("Campaigns&action")) 
		 * { break; } 
		 * }
		 */
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'and @class='crmButton small save']")).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriverClass.mouseHoverOnTheElement(driver, ele1);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		ExcelData.saveExcelData();
		ExcelData.closeExcel();
		webdriverClass.quitBrowser(driver);
	// FileOutputStream  fos=new FileOutputStream("./src/test/resources/data.xlsx");
	// wb.write(fos);
	 //wb.close();
		}
		}
		




