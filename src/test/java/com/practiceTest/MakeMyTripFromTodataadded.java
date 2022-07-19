package com.practiceTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.IconstantPath;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFromTodataadded {
/*	@DataProvider(name="fromtodata")
	public Object[][] method() throws EncryptedDocumentException, IOException {
		ExcelData.openExcel(IconstantPath.EXCELPATH);
		 Object[][] muldata = ExcelData.getMultipleDataFromExcelArray("mmt from");
		 return muldata;
	}
	

	@Test(dataProvider="fromtodata")
		public void method(String from, String to) throws InterruptedException 
	{*/
	
		//System.out.println(from+" "+ to);
	
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		int reqDate = 31;
		String reqMonth = "Aug";
		int reqYear = 22;
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions opts=new ChromeOptions();
	opts.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opts);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	//driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
    Thread.sleep(6000);

	/*
	 * driver.findElement(By.xpath("//span[.='From']")).click(); Thread.sleep(5000);
	 * driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bangaluru");
	 * Thread.sleep(4000); 
	 * driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and contains(.,'Bangaluru')]")).click(); driver.findElement(By.xpath("//span[ .='To']")).click();
	 * Thread.sleep(3000); 
	 * driver.findElement(By.id("toCity")).sendKeys("Delhi");
	 * Thread.sleep(4000); 
	 * driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and contains(.,'Delhi')]")).click(); Thread.sleep(4000);
	 */

    
	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	Thread.sleep(3000);
	WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and .='July 2022']"));
	String currentMonth = ele.getText().split(" ")[0];
	String currentYear = ele.getText().split(" ")[1];
	System.out.println(currentMonth);
	
	System.out.println(currentYear);
	
	/*
	 * try { WebElement ele = driver.findElement(By.
	 * xpath("//div[@class='DayPicker-Caption' and .='July 2022']")); } catch {
	 * driver.findElement(By.xpath("")); } if(reqYear>=)
	 */
	
	
	
	driver.findElement(By.xpath("//div[@aria-label='Sat Jul 30 2022']")).click();

	driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and contains(.,'RETURN')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@aria-label='Tue Aug 16 2022']")).click();

	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
	driver.close();
		}
}
