package com.practiceTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.molecularinstruments.com/?utm_source=bing&utm_medium=cpc&utm_campaign=IHC&utm_term=ICC&utm_content=Immunocytochemistry");
		List<WebElement> alle = driver.findElements(By.xpath("//*[name()='span' and .='Protocols']/ancestor::div[@data-testid='linkElement']/following-sibling::div/descendant::span"));
		for(int i=0;i<alle.size();i++) 
		{
			System.out.println(alle.get(i).getAttribute("href").split("/")[1]);
		}

	}

}
