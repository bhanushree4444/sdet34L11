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

public class PracticeTestNgTest {

	@BeforeSuite(groups = "baseclass")
	public  void beforeSuite1Test() {
		Reporter.log("beforeSuite1",true);
	}
	@BeforeSuite
	public  void beforeSuite2Test() {
		Reporter.log("beforeSuite2",true);
	}
	
	
	@AfterSuite(groups = "baseclass")
	public  void afterSuite2Test() {
		Reporter.log("afterSuite2",true);
	}

	@BeforeTest(groups = "baseclass")
	public  void beforeTest1Test() {
		Reporter.log("BeforeTest1",true);
	}

	@AfterTest(groups = "baseclass")
	public  void afterTest1Test() {
		Reporter.log("afterTest1",true);
	}

	

	@BeforeClass(groups = "baseclass")
	public  void beforeClass1Test() {
		Reporter.log("BeforeClass1",true);
	}

	@AfterClass(groups = "baseclass")
	public  void afterClass1Test() {
		Reporter.log("afterClass1",true);
	}


	@BeforeMethod(groups = "baseclass")
	public  void BeforeMethod1Test() {
		Reporter.log("BeforeMethod1",true);
	}

	@AfterMethod(groups = "baseclass")
	public  void AfterMethod1Test() {
		Reporter.log("afterMethod1",true);
	}

	@BeforeMethod(groups = "baseclass")
	public  void BeforeMethod2Test() {
		Reporter.log("BeforeMethod2",true);
	}


	@Test(groups = "regression")
	public  void test1Test() {
		Reporter.log("hi",true);
	}

	@Test(groups = "sanity")
	public  void test2Test() {
			Reporter.log("hello",true);
	}

	@Test(groups = {"regression","sanity"})
    public  void test3Test() {
		Reporter.log("bye",true);
		
	}

	
}
