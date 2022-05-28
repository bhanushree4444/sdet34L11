  package com.sdetl1.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * this class contains only java specific reusable methods
 * @author Madhu
 *
 */
public class JavaGenericClass {
	
	/**
	 * this method used to convert string datatype to long datatype
	 * @param value
	 * @return
	 */
	public long stringToLong(String value) {
		return Long.parseLong(value);
	}
	
	/**
	 * this method used to get the random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	
	/**
	 * this method used compare actual with expected result
	 * @param actualResult
	 * @param ExpectedResult
	 * @param testCaseName
	 */
	public void assertionThroughCondition(String actualResult,String ExpectedResult,String testCaseName) {
		if(actualResult.equalsIgnoreCase(ExpectedResult)) {
			System.out.println(testCaseName+" created successfully");
			System.out.println("Tc pass");
		}
	}
	/**
	 * this method used compare actual with expected result using contains
	 * @param actualResult
	 * @param ExpectedResult
	 * @param testCaseName
	 */
	public void assertionThroughConditionContains(String actualResult,String ExpectedResult,String testCaseName) {
		if(actualResult.contains(ExpectedResult)) {
			System.out.println(testCaseName+" created successfully");
			System.out.println("Tc pass");
		}
	}
	
	/**
	 * this method used to give custom wait
	 * @param element
	 * @param polingTime
	 * @param duration
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element,long polingTime,int duration) throws InterruptedException {
		int count=0;
		while(count<=duration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(polingTime);
				count++;
			}
		}
	}
	
	/**
	 * this method used to get date in simple format that is dd_MM_yyyy_HH_mm_sss
	 * @return
	 */
	public String dateTimeInFormat() {
		return new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss").format(new Date());
	}
	
	/**
	 * this method used to print the statement
	 * @param message
	 */
	public void printStatement(String message) {
		System.out.println(message);
	}

	
}
