package com.practiceTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
           
	 public static void takeScreenShot(String fileName,WebDriver driver) throws IOException {
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String dateTime = new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss").format(new Date());
		 File dst = new File("./screenshot/"+fileName+"_"+dateTime+".png");
		 System.out.println(dst.getAbsolutePath());
		 FileUtils.copyFile(src, dst);
	 }
	
}
