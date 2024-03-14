package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class ManageDeliveryBoyTest extends Base 
{
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboy;
	@Test
	public void verifyNewDeliveryboycreation()
	{
		loginpage= new LoginPage(driver);
		managedeliveryboy= new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboy.clickOnManageDeliveryBoyButton();
		String fname=GeneralUtility.get_RandomFirstName();
		managedeliveryboy.saveNewDeliveryBoy("Subi "+fname, "subi@gmail.com", "12365", "anus", "leon "+fname, "123");
		String actualAlert=managedeliveryboy.get_SaveAlert();
		String expectedAlert="Alert!";
		Assert.assertEquals(actualAlert, expectedAlert);
	}
	@Test
	public void verifyAllFieldNewDeliveryBoyCreation()
	{
		loginpage= new LoginPage(driver);
		managedeliveryboy= new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboy.clickOnManageDeliveryBoyButton();
		managedeliveryboy.clickOnNew();
		List<String>expectedFieldList= new ArrayList<String>();
		List<String>actualFieldList=managedeliveryboy.printAllFieldsNames();
		expectedFieldList.add("Name");
		expectedFieldList.add("Email");
		expectedFieldList.add("Phone Number");
		expectedFieldList.add("Address");
		expectedFieldList.add("Username");
		expectedFieldList.add("Password");
		Assert.assertEquals(actualFieldList, expectedFieldList);
	}	
}
