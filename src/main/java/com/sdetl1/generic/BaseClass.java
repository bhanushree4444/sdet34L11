package com.sdetl1.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.ObjectRepository.HomePage;
import com.Vtiger.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class contains common actions for @test
 * @author Madhu
 *
 */
public class BaseClass {
	public String url;
	public String USERNAME;
	public  long timeout;
	public String PASSWORD;
	public String browser;
	protected WebDriver driver=null;
	public JavaGenericClass jutil;
	public LoginPage loginpage;
	public HomePage homepage;
	public int randomNumber;
	public WebdriverClass webdriverClass;
	public static WebDriver staticdriver;
	
	/**
	 * this method used to open excel and property file
	 * @throws IOException
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforSuite1Test() throws IOException {
		PropertyFile.open_property_file(IconstantPath.PROPERTYFILEPATH);
		ExcelData.openExcel(IconstantPath.EXCELPATH);
	}
	/**
	 * this method used to fetch login cradencials and created object for login page launch and set settings to browser 
	 * @throws IOException
	 */
	//@Parameters ("browser")
	@BeforeClass(groups = "baseclass")
	public void beforClass(/*String browser*/) throws IOException {
		  jutil=new JavaGenericClass();
		  randomNumber = jutil.getRandomNumber(1000);
//		 url = PropertyFile.get_data_propertyfile("url");
//		 username = PropertyFile.get_data_propertyfile("username");
		 String timeout1 = PropertyFile.get_data_propertyfile("timeout");
//		 password = PropertyFile.get_data_propertyfile("password");
//	     browser = PropertyFile.get_data_propertyfile("browser");
		 String USERNAME=System.getProperty("USERNAME");
		 System.out.println(USERNAME);
		 String PASSWORD=System.getProperty("PASSWORD");
		 System.out.println(PASSWORD);
		 String browser=System.getProperty("BROWSER");
		 String url=System.getProperty("URL");
		 
		 timeout= jutil.stringToLong(timeout1);
		 
		
			
			switch(browser) {
			case "chrome": {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
			case "firefox": {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			}
			default: {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			}
				}
			
			staticdriver=driver;
		 loginpage=new LoginPage(driver);
		     homepage=new HomePage(driver);
		     webdriverClass=new WebdriverClass();
		
    webdriverClass.actionsClassInvoke(driver);
	 WebdriverClass.navigateApp(url, driver);
	 webdriverClass.browserSetting(timeout, driver);
	 }
	/**
	 * this method used to login to application
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod() {
		loginpage.loginAction(USERNAME,PASSWORD);
	}
	/**
	 * this method used to logout the application
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethod() {
		 homepage.logoutClick(driver,webdriverClass);
	}
	/**
	 * this method used to quit the browser
	 */
	@AfterClass(groups = "baseclass")
	public void afterClass() {
		webdriverClass.quitBrowser(driver);
	}
	/**
	 * this method used to save excel and close excel
	 * @throws IOException
	 */
	@AfterSuite(groups = "baseclass")
	public void afterSuite() throws IOException {
		//ExcelData.saveExcelData();
		ExcelData.closeExcel();
	}
}
