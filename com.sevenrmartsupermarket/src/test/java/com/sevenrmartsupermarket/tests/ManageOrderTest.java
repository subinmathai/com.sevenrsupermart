package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrderPage;

public class ManageOrderTest extends Base {
	LoginPage loginpage;
	 HomePage homepage;
	 ManageOrderPage manageorderpage;
	 @Test
	 public void verifyOrderSearch()
	 {
		 loginpage= new LoginPage(driver);
		 loginpage.login();
		 manageorderpage= new ManageOrderPage(driver);
		 manageorderpage.clickOnManageOrder();
		 manageorderpage.searchAnOrder();
		 
		 
	 }
	 @Test
	 public void verifyUpdateOrderChangeStatus()
		{
		 loginpage= new LoginPage(driver);
		 loginpage.login();
		 manageorderpage= new ManageOrderPage(driver);
		 manageorderpage.clickOnManageOrder();
		 manageorderpage.searchAnOrder();
		 manageorderpage.selectDeliveryStatus();
		}
	 @Test
	public void verifyStatusIsUpdated()
	{
		 loginpage= new LoginPage(driver);
		 loginpage.login();
		 manageorderpage= new ManageOrderPage(driver);
		 manageorderpage.clickOnManageOrder();
		 manageorderpage.searchAnOrder();
		 String actualStatus= manageorderpage.checkCurrentDeliveryStatus();
		 String expectedStatus= "PAID";
		 Assert.assertEquals(actualStatus, expectedStatus);
	}
	 
		 
	 

}
