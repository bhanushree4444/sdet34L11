package com.PracticeJAVA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spicejrt {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeOptions opts=new ChromeOptions();
	opts.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opts);
	driver.get("https://www.spicejet.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//WebDriverWait wait=new WebDriverWait(driver, 10);
Thread.sleep(8000);
driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1i10wst r-tceitz r-u8s1d css-76zvg2']")).click();
driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'][1]")).sendKeys("BLR");
driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'][2]")).sendKeys("del");

/*
 * WebElement ele2 = driver.findElement(By.
 * xpath("//div[@class='r-1862ga2 r-1loqt21 r-1i10wst r-tceitz r-u8s1d css-76zvg2']"
 * )); wait.until(ExpectedConditions.visibilityOf(ele2)); ele.sendKeys("del");
 */
	}

}
