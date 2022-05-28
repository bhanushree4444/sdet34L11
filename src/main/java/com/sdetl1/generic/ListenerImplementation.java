package com.sdetl1.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener{
	
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Environment", "Testing Environment");
		reports.setSystemInfo("Reporter Name", "Bhanushree N");
		reports.setSystemInfo("Platform", "Windows 10");
		reports.setSystemInfo("Unit Testing Tool", "TESTNG");
		reports.setSystemInfo("Build Management Tool", "Maven");
		reports.setSystemInfo("Automation Tool", "Selenium");
		
		
	}
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		WebdriverClass webdriverClass=new WebdriverClass();
		JavaGenericClass javaGenericClass=new JavaGenericClass();
		try {
			test.addScreenCaptureFromPath(webdriverClass.takeScreenShot(result.getMethod().getMethodName(), BaseClass.staticdriver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		reports.flush();
		
	}

}
