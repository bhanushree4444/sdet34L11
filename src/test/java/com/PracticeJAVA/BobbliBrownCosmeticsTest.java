package com.PracticeJAVA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BobbliBrownCosmeticsTest {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://bobbibrowncosmetics.com");
	Thread.sleep(8000);
	List<WebElement> allEle = driver.findElements(By.xpath("//div[@class='product-brief__abstract']/h4"));
	for(WebElement ele:allEle) {
		System.out.println(ele.getSize());
		System.out.println(ele.getText());
	}
}
}
