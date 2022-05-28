package com.practiceTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdetl1.generic.IconstantPath;
import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchUsingGenericPropTest {

	public static void main(String[] args) throws IOException {
		JavaGenericClass jutil=new JavaGenericClass();
		PropertyFile.open_property_file(IconstantPath.PROPERTYFILEPATH);
		String url = PropertyFile.get_data_propertyfile("url");
		String username = PropertyFile.get_data_propertyfile("username");
		String timeout = PropertyFile.get_data_propertyfile("timeout");
		String password = PropertyFile.get_data_propertyfile("password");
		String browser = PropertyFile.get_data_propertyfile("browser");
		
		long timeout1 = jutil.stringToLong(timeout);
		int ran = jutil.getRandomNumber(1000);
		System.out.println(url);
		System.out.println(username);
		System.out.println(timeout1);
		System.out.println(ran);

		
		WebDriver driver=null;
	    switch(browser) {
	    case"chrome":
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    	break;
	    case"firefox":
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	break;
	    default:
	    		System.out.println("please speccify the browser");
	    		WebDriverManager.firefoxdriver().setup();
	    		driver=new FirefoxDriver();
	    }
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(timeout1, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		
	}

}
