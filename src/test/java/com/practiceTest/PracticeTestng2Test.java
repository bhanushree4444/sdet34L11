package com.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestng2Test extends PracticeTestNgTest {

	
	@BeforeSuite
	public  void beforeSuite5Test() {
		Reporter.log("beforeSuite5",true);
	}
	
	@BeforeTest
	public  void beforeTest5Test() {
		Reporter.log("BeforeTest5",true);
	}
	
	@AfterSuite
	public  void afterSuite55Test() {
		Reporter.log("afterSuite55",true);
	}

	@AfterTest
	public  void afterTest5Test() {
		Reporter.log("afterTest5",true);
	}
	@BeforeClass
	public  void BeforeClass5Test() {
		Reporter.log("BeforeCLass5",true);
	}

	@AfterClass
	public  void AfterClass5Test() {
		Reporter.log("afterClass5",true);
	}

	@BeforeMethod(groups = "regression")
	public  void BeforeMethod5Test() {
		Reporter.log("BeforeMethod5",true);
	}

	@AfterMethod (groups = "sanity")
	public  void AfterMethod5Test() {
		Reporter.log("afterMethod5",true);
	}
	
	
	@Test (groups = "baseclass")
	public  void Test5Test() {
		Reporter.log("ultimate",true);
		
	}
}
