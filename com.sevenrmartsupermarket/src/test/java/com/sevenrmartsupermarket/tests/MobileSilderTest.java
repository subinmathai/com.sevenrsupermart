package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.MobileSliderPage;

public class MobileSilderTest extends Base {
	LoginPage loginpage;
	MobileSliderPage mobilesliderpage;
	@Test
	public void verifyGetInMobileSilderpage()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		mobilesliderpage= new 	MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderLink();
	}
	@Test
	public void verifyNewMobileSilderInformationSave()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		mobilesliderpage= new 	MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderLink();
		mobilesliderpage.saveNewMobileSilderInformation();
	}
}
