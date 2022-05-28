package com.rmgyantraProjectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdetl1.generic.WebdriverClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrateProjectTest {

	public static void main(String[] args) throws SQLException {
		WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		 driver.get("http://localhost:8084");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 driver.findElement(By.xpath("//a[.='Projects']")).click();
		 driver.findElement(By.xpath("//span[.='Create Project']")).click();
		 String projectName = "SDET34L1-6";
		 driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		 
		// JavascriptExecutor js=(JavascriptExecutor) driver;
		 // js.executeScript("document.getElementByName('teamSize', value='4')");
		 WebdriverClass webdriverClass=new WebdriverClass();
		 driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sangi");
		 WebElement projectStatusDropdown = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		 webdriverClass.selectClassInvoke(projectStatusDropdown);
		 webdriverClass.selectByVisibletext("Created");
			/*
			 * Select s=new Select(projectStatusDropdown); 
			 * s.selectByVisibleText("Created");
			 */
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		  Connection connection=null;
		    try {
				Driver d = new Driver();
				DriverManager.registerDriver(d);
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select project_name from project");
				while(result.next()){
					if(result.getString("project_name").equals(projectName)) 
					{
						System.out.println("project name is present");
						System.out.println("tc pass");
					}
		    }
		    }
		    finally {
				connection.close();
				driver.quit();
		}
	

}
}