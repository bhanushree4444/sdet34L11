package com.practiceTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	
	public static void main(String[] args) throws InterruptedException 
{
WebDriverManager.chromedriver().setup();
ChromeOptions opts=new ChromeOptions();
opts.addArguments("--disable-notifications");
WebDriver driver=new ChromeDriver(opts);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://www.makemytrip.com/");
Thread.sleep(3000);
driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
//driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();


//ExcelData excelData=new ExcelData();
// Object[][] muldata = excelData.getMultipleDataFromExcelArray("mmt from");

driver.findElement(By.xpath("//span[.='From']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("bangalore");
Thread.sleep(4000);
driver.findElement(By.xpath("//div[.='BLR']")).click();
driver.findElement(By.xpath("//span[ .='To']")).click();
Thread.sleep(3000);
driver.findElement(By.id("toCity")).sendKeys("delhi");
Thread.sleep(4000);
driver.findElement(By.xpath("//div[.='DEL']")).click();
Thread.sleep(4000);

driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@aria-label='Sat Jul 30 2022']")).click();

driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and contains(.,'RETURN')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@aria-label='Tue Aug 16 2022']")).click();

driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
driver.close();
	}

}
