package com.practiceTest;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpicejetCal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crm=new ChromeOptions();
		crm.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(crm);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		String fromAdd="BLR";
		String toAdd="DEL";
		WebElement from=driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@type='text']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(from));
		from.sendKeys(fromAdd);
		WebElement to=driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		to.sendKeys(toAdd);
		int reqDate = 25;
		String reqYear = "2022";
		String reqMonth = "January"; // MMMM = January, MM=01, MMM=Jan 
		int reqMothOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		 int reqYearInNumber = Integer.parseInt(reqYear);
			//driver.findElement(By.xpath("//input[@id='datepicker']")).click();
			Thread.sleep(3000);
			String[] currenMonthWithYear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj']")).getText().split(" ");
			String currentMonth = currenMonthWithYear[0];
			int currentMothOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);
			String currentYear=currenMonthWithYear[1] ;
			int currentYearInNumber = Integer.parseInt(currentYear);
	}

}
