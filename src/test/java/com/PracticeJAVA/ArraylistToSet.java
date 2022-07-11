package com.PracticeJAVA;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArraylistToSet {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opts=new ChromeOptions();
		opts.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opts);
		 driver.get("http://flipkart.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//button[.='✕']")).click();
		 List<WebElement> allEle = driver.findElements(By.xpath("//a"));

		 ArrayList<String> list=new ArrayList<>(); 
		 for(WebElement ele:allEle) {
			  list.add(ele.getText()); 
			  
		 }
			 
		 LinkedHashSet<String> set=new LinkedHashSet<String>();
		 for(String ele1:list)
		 {
			 set.add(ele1);
		 }
		 
		 for(String ele2:set)
		 {
			 System.out.println(ele2);
		 }
		 
		 driver.quit();
		 
		 

	}

}
