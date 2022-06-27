package com.vtiger.Organization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewOrganizationPage;
import com.Vtiger.ObjectRepository.OganizationHomePage;
import com.Vtiger.ObjectRepository.OrganizationInformationPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;

public class OrganizationNames extends BaseClass{
	@Test
	public void organizationName() throws InterruptedException {
		
	String organization= ExcelData.getDataFromExcel("tdOrganization", 3, 1)+randomNumber;
	 
   OganizationHomePage  organizationHomePage =new OganizationHomePage (driver);
    CreatingNewOrganizationPage creatingNewOrganization=new CreatingNewOrganizationPage(driver);
    OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		homepage.organizationClick();
		organizationHomePage.organizationIconClick();
		creatingNewOrganization.organizationNameSend(organization);
		creatingNewOrganization.saveButtonClick();
		jutil.assertionThroughCondition(organizationInformationPage.createdOrganizationText(), organization, "Organization  ");
		driver.findElement(By.linkText("Organizations")).click();
		
	String xpath = "//table[@class='lvt small']/tbody/tr[1]/td";
	List<WebElement> webele = driver.findElements(By.xpath(xpath));
	for(WebElement ele:webele) {
		System.out.println(ele.getText());	
	}
	
	int pageCount = Integer.parseInt(driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName' and @class='small']")).getText().split(" ")[1]);
	System.out.println(pageCount);
	
	for(int i=1;i<=pageCount;i++) {
	int count = 0;
	List<WebElement> orgNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody//td[3]"));
	for(int j=1;j<orgNames.size();j++)
	{
		if(orgNames.get(j).getText().equalsIgnoreCase(organization)) {
		    Reporter.log("entered",true);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[.='"+organization+"']/../preceding-sibling::td/input[@name='selected_id']")).click();
			Reporter.log("organization selected",true);
			count++;
			break;
		}
	}
		if(count!=0) {
			break;
		}
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		Thread.sleep(4000);
	}
	driver.findElement(By.xpath("//table[@class='layerPopupTransport']/following-sibling::table[@class='small']//input[@value='Delete']")).click();	
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	
	}
	}
	
	
