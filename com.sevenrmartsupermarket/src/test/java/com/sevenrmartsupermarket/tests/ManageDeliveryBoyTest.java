package com.sevenrmartsupermarket.tests;

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
		System.out.println(fname);
		managedeliveryboy.createNewDeliveryBoy("Subi "+fname, "subi@gmail.com", "12365", "anus", "leon "+fname, "123");
		
	
	}
	
}
