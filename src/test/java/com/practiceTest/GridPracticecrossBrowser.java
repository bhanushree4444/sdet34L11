package com.practiceTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridPracticecrossBrowser {
	RemoteWebDriver driver;
    @Parameters("browser")
	@BeforeClass
	public void  gridPractice(String browser) throws MalformedURLException {
	URL url=new URL("http://192.168.92.30:5555/wd/hub"); //should specify other laps ip address
	DesiredCapabilities cap=new DesiredCapabilities();
	if(browser.equals("chrome")) {
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
	}else if(browser.equals("firefox")) {
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
	}
	 driver=new RemoteWebDriver(url, cap);
	}
    @Test
    public void remoteExecution() {
    	driver.get("http://gmail.com");
    }
}

