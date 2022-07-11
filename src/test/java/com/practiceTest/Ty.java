package com.practiceTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ty {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.hotstar.com/in/list/latest-trending/t-7071_25_2");
	List<WebElement> allEle = driver.findElements(By.xpath("//span[@class='content-title ellipsise']/ancestor::a"));
	
	/*
	 * driver.get("https://www.hotstar.com/in"); List<WebElement>
	 * allEle=driver.findElements(By.
	 * xpath("//a[.='Latest & Trending']/ancestor::div[@class='container']/following-sibling::div/descendant::a"
	 * ));
	 */
	for(int i=0;i<allEle.size();i++){
		    System.out.println(allEle.get(i).getAttribute("to").split("/")[3]);
		    
      	 }
      }

}


