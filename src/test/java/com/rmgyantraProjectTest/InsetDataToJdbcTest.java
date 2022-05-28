package com.rmgyantraProjectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdetl1.generic.DatabaseUtility;
import com.sdetl1.generic.IconstantPath;
import com.sdetl1.generic.JavaGenericClass;
import com.sdetl1.generic.PropertyFile;
import com.sdetl1.generic.WebdriverClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsetDataToJdbcTest {

	public static void main(String[] args) throws SQLException, IOException {
		PropertyFile.open_property_file(IconstantPath.RMG_PROPERTYFILEPATH);
		JavaGenericClass jutil = new JavaGenericClass();
		int ran = jutil.getRandomNumber(1000);
		String dbusername = PropertyFile.get_data_propertyfile("dbusername");
		String dbpassword = PropertyFile.get_data_propertyfile("dbpassword");
		String databasename = PropertyFile.get_data_propertyfile("databasename");
		String rmgusername = PropertyFile.get_data_propertyfile("rmgusername");
		String rmgpassword = PropertyFile.get_data_propertyfile("rmgpassword");
		String projectname = PropertyFile.get_data_propertyfile("projectname");
		String timeout1= PropertyFile.get_data_propertyfile("timeout");
		String rmgurl = PropertyFile.get_data_propertyfile("rmgurl");
		
		 long timeout = jutil.stringToLong(timeout1);
			
		DatabaseUtility.openDbConnection(IconstantPath.RMGYANTRA_DATABASE_URL+databasename, dbusername, dbpassword);
		DatabaseUtility.setDataIntoDb("insert into project values('TY_PROJ_789', 'bhanu', '28/04/2022', '"+projectname+"','on Going', 6);");
		
		
		
		
		
		
		
		 //String projectName = "SDET34L1-7";
			/*
			 * try { Driver driver=new Driver(); DriverManager.registerDriver(driver);
			 * connection =
			 * DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root",
			 * "root"); Statement statement = connection.createStatement(); statement.
			executeUpdate("insert into project values('TY_PROJ_010', 'bhanu', '28/04/2022', '"+projectName+"','on Going', 5);"); 
			} finally { connection.close();
			 * System.out.println("database dis-connected"); }
			 */
		 WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		 WebdriverClass webdriverClass=new WebdriverClass();
		 webdriverClass.navigateApp(rmgurl, driver);
	
		 webdriverClass.browserSetting(timeout, driver);
		 
		 driver.findElement(By.id("usernmae")).sendKeys(rmgusername);
		  driver.findElement(By.id("inputPassword")).sendKeys(rmgpassword);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 
		 
		 
		 
			/*
			 * driver1.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			 * driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			 * driver1.findElement(By.xpath("//button[@type='submit']")).click();
			 */
		
		 driver.findElement(By.xpath("//a[.='Projects']")).click();
		 List<WebElement> listofProjects = driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		 for( WebElement projects:listofProjects)
		 {
			if(projects.getText().equalsIgnoreCase(projectname)) {
				System.out.println("project name is visible through GUI");
				System.out.println("tc pass");
				break;
				}
			}
		 
		 DatabaseUtility.colseDBConnection();
			 driver.close();
		 
		 
	}
}

