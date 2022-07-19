package com.practiceTest;
import java.time.LocalDate;
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

public class SpiceJet {

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
		String[] currenMonthWithYear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj' and contains(.,'July ')]")).getText().split(" ");
		String currentMonth = currenMonthWithYear[0];
		int currentMothOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);
		String currentYear=currenMonthWithYear[1] ;
		int currentYearInNumber = Integer.parseInt(currentYear);
		 
		while(reqYearInNumber < currentYearInNumber || reqMothOfYear<currentMothOfYear) {
			 currenMonthWithYear = driver.findElement(By.xpath("//div[@class='css-1]")).getText().split(" ");
			 currentMonth = currenMonthWithYear[0];
			 currentMothOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);
			  currentYear=currenMonthWithYear[1] ;
			currentYearInNumber = Integer.parseInt(currentYear);
		}
		try {
			driver.findElement(By.xpath("//a[@class='ui-state-default' and test()='"+reqDate+"']")).click();
		}
		catch(Exception e){
			System.out.println("invalid data input "+reqDate+"/"+reqMonth+"/"+reqYear);
		}
		SpiceJet.selectDate(driver,"20-August-2022");
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();

	}

	public static void selectDate(WebDriver driver, String date) {
		
		int reqMonth=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear=Integer.parseInt(date.split("-")[2]);

		String currentMonthYear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj' and contains(.,'July 20')][1]")).getText();
		int currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
		int currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		while(!(currentMonth==reqMonth && currentYear==reqYear))
		{
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj' and contains(.,'August 20')][1]")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		}
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(.,'"+date.split("-")[1]+"')]//p[.='"+date.split("-")[0]+"']")).click();
	}
}


