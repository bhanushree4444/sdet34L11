package com.Contact.TC61toTC65;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRepository.CreatingNewCurrencyPage;
import com.Vtiger.ObjectRepository.CurrenciesInSettingPage;
import com.Vtiger.ObjectRepository.SettingsPage;
import com.sdetl1.generic.BaseClass;

public class Tc65_Create_New_Group extends BaseClass{
@Test
	public void tc65_Create_New_Group() throws IOException{
	
	    
	    SettingsPage  settingsPage =new SettingsPage (driver);
	    CreatingNewCurrencyPage creatingNewCurrencyPage=new CreatingNewCurrencyPage(driver);
	    CurrenciesInSettingPage currenciesInSetting=new CurrenciesInSettingPage(driver);
			 homepage.settingsClickWithCrm(driver,webdriverClass);
			 settingsPage.currencyInSettingsClick();
			 currenciesInSetting.newCurrencyButtonClick();
			 creatingNewCurrencyPage.currencyNameDropDownSelectByValue("Albania, Leke",webdriverClass);
			 creatingNewCurrencyPage.sendConversionRate("6");
			 creatingNewCurrencyPage.saveButtonClick();
	}
}
