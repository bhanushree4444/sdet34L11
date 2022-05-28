package com.Contact.TC61toTC65;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreateNewGroupInSettingsPage;
import com.Vtiger.ObjectRepository.GroupsInSettingsPage;
import com.Vtiger.ObjectRepository.SettingsPage;
import com.sdetl1.generic.BaseClass;
import com.sdetl1.generic.ExcelData;
import com.sdetl1.generic.WebdriverClass;

public class Tc64_Create_New_GroupMgr extends BaseClass  {
@Test
	public void tc64_Create_New_Group() throws IOException, InterruptedException {
	   
	    SettingsPage  settingsPage =new SettingsPage (driver);
	    GroupsInSettingsPage groupsInSettings=new GroupsInSettingsPage(driver);
	    CreateNewGroupInSettingsPage createNewGroupInSettings=new CreateNewGroupInSettingsPage(driver);
	    String groupname= ExcelData.getDataFromExcel("groupname", 0, 0);
			 homepage.settingsClickWithCrm(driver,webdriverClass);
			 settingsPage.groupsInSettingsClick();
			 groupsInSettings.newGroupButtonClick();
			 createNewGroupInSettings.groupNameSend(groupname);
			 createNewGroupInSettings.selectmMemberOfEntityInGroup();
			 createNewGroupInSettings.addButtonClick();
			 createNewGroupInSettings.addGroupButtonClick();
		webdriverClass.explicitlyWait(driver, timeout);
		webdriverClass.waitUntillAlertVisible();
	 webdriverClass.switchToAlert(driver);	 
	 webdriverClass.alertAccept(driver);
	}
}
