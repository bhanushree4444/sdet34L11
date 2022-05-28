package com.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromDbTest {
	public static void main(String[] args) throws SQLException {
	      Connection connection=null;
	    try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from sdet1;");
			
			String url = "";
			String username = "";
			String password = "";
			String timeouts = "";
			String organization = "";
			String browser = "";
			
			while(result.next()){
			url= result.getString("url");
			username= result.getString("username");
			password=result.getString("password");
			timeouts=result.getString("timeouts");
			organization=result.getString("organization");
			browser =result.getString("browserName");
			}
			
	    System.out.println(url);
	    System.out.println(username);
	    System.out.println(password);
	    long logTimeOut = Long.parseLong(timeouts);
	    WebDriver driver=null;
	    switch(browser) {
	    case "chrome":
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    	break;
	    case "firefox":
	    	WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
	    default:
				 System.out.println("please specify the browser");
				 WebDriverManager.firefoxdriver().setup();
	    	}
			
			 driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(logTimeOut,TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
			 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
			 driver.findElement(By.xpath("//input[@type='submit']")).click();
			 driver.findElement(By.xpath("//a[.='Contacts']")).click();
			 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			 String firstName = "sdet34";
			 String lastName = "L2";
			 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
			 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
			 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			 WebElement actualFirstname = driver.findElement(By.xpath("//span[@id='dtlview_First Name']"));
			 WebElement actualLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
			 
			 if(actualFirstname.getText().equalsIgnoreCase(firstName)&&actualLastName.getText().equalsIgnoreCase(lastName))
			 {
				 System.out.println("contact created successfully");
				 System.out.println("tc pass");
			 }
			 
			 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 Actions a=new Actions(driver);
			 a.moveToElement(ele).perform();
			 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			 driver.close();
	    	}
	    
	    	finally {
			connection.close();
			System.out.println("sqlDB connection closd");
	    	}
			}
}