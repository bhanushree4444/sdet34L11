package com.vtiger.Organization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdetl1.generic.BaseClass;

public class OrganizationNamesPrint extends BaseClass {
	@Test
	public void organizationName() throws InterruptedException {
		
		homepage.organizationClick();
		
	String xpath = "//table[@class='lvt small']/tbody/tr[1]/td";
	List<WebElement> columnNames = driver.findElements(By.xpath(xpath));
	
for(int i=0;i<columnNames.size();i++) 
{
	if(columnNames.get(i).getText().equalsIgnoreCase("Organization Name")) // get is a method of list
	{
	List<WebElement> allOrgNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td["+(i+1)+"]"));
	for(WebElement orgNames:allOrgNames) {
		System.out.println(orgNames.getText());
	}
	}
		
	}	
	}
}
