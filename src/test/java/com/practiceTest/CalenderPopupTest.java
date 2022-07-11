package com.practiceTest;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(5000);
		int reqDate = 25;
		String reqYear = "2020";
		String reqMonth = "January"; // MMMM = January, MM=01, MMM=Jan 
		int reqMothOfYear = DateTimeFormatter.ofPattern("MMMM").
				withLocale(Locale.ENGLISH)
				.parse(reqMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		 int reqYearInNumber = Integer.parseInt(reqYear);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String[] currenMonthWithYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().split(" ");
		String currentMonth = currenMonthWithYear[0];
		int currentMothOfYear = DateTimeFormatter.ofPattern("MMMM").
				withLocale(Locale.ENGLISH)
				.parse(currentMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		String currentYear=currenMonthWithYear[1] ;
		int currentYearInNumber = Integer.parseInt(currentYear);
		while(reqYearInNumber < currentYearInNumber || reqMothOfYear<currentMothOfYear) {
			 currenMonthWithYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().split(" ");
			 currentMonth = currenMonthWithYear[0];
			 currentMothOfYear = DateTimeFormatter.ofPattern("MMMM").
						withLocale(Locale.ENGLISH)
						.parse(currentMonth)
						.get(ChronoField.MONTH_OF_YEAR);
			  currentYear=currenMonthWithYear[1] ;
			currentYearInNumber = Integer.parseInt(currentYear);
		}
		try {
			driver.findElement(By.xpath("//a[@class='ui-state-default' and test()='"+reqDate+"']")).click();
		}
		catch(Exception e){
			System.out.println("invalid data input "+reqDate+"/"+reqMonth+"/"+reqYear);
		}
	}
}
