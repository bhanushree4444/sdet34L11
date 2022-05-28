package com.PracticeOld;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdetl1.generic.IconstantPath;
import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.PropertyFile;
import com.sdetl1.generic.WebdriverClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropCreateCampaignsTest {

	public static void main(String[] args) throws IOException {
		JavaGenericClass jutil=new JavaGenericClass();
		PropertyFile.open_property_file(IconstantPath.PROPERTYFILEPATH);
		String url = PropertyFile.get_data_propertyfile("url");
		String username = PropertyFile.get_data_propertyfile("username");
		String timeout = PropertyFile.get_data_propertyfile("timeout");
		String password = PropertyFile.get_data_propertyfile("password");
		String browser = PropertyFile.get_data_propertyfile("browser");
		
		long timeout1 = jutil.stringToLong(timeout);
		//int ran = jutil.getRandomNumber(1000);
		WebDriver driver=null;
		switch(browser) {
		case "chrome":{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		case "firefox":{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
		default: {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		}
		WebdriverClass webdriverClass=new WebdriverClass();
        webdriverClass.navigateApp(url, driver);
        webdriverClass.browserSetting(timeout1, driver);
		 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 WebElement ele =driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		 webdriverClass.mouseHoverOnTheElement(driver, ele);
		 driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		 driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 driver.findElement(By.name("campaignname")).sendKeys("amma");
		 driver.findElement(By.name("button")).click();
		 WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 webdriverClass.mouseHoverOnTheElement(driver, ele1);
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		 

	}

}
