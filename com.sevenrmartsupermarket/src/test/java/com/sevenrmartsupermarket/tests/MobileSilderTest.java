package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
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
		String actualTitle=mobilesliderpage.get_MobileSliderPageTitle();
		String ExpectedTitle="List Mobile Sliders";
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}
	@Test
	public void verifyNewMobileSilderInformationSave()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		mobilesliderpage= new 	MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderLink();
		mobilesliderpage.saveNewMobileSilderInformation();
		String actualAlert=mobilesliderpage.get_AlertMessage();
		Assert.assertEquals(actualAlert, "�\r\n"
				+ "Alert!\r\n"
				+ "Mobile Slider Created Successfully!");
	}
	@Test
	public void verifyFieldInNewMobileSilderSavePage()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		mobilesliderpage= new 	MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderLink();
		mobilesliderpage.clickOnNew();
		List<String>actualField=mobilesliderpage.get_AllFieldAddMobileSlider();
		List<String>expectedField= new ArrayList<String>();
		expectedField.add("Category");
		expectedField.add("Image");
		Assert.assertEquals(actualField, expectedField);
	}
}
