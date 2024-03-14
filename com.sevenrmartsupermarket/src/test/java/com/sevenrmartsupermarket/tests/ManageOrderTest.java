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
		 String actualTitle=manageorderpage.get_searchOrderfieldTittle();
		 String expectedTitle="Search List Orders";
		 Assert.assertEquals(actualTitle, expectedTitle);
		 
	 }
	 @Test
	 public void verifyUpdateOrderChangeStatusPage()
		{
		 loginpage= new LoginPage(driver);
		 loginpage.login();
		 manageorderpage= new ManageOrderPage(driver);
		 manageorderpage.clickOnManageOrder();
		 manageorderpage.searchAnOrder();
		 manageorderpage.selectDeliveryStatus();
		 String actualTitle=manageorderpage.statusUpadatePageTitle();
		 String expectedTitle="Update Status Order Id :121";
		 Assert.assertEquals(actualTitle, expectedTitle);
		}
	 @Test
	public void verifyOrderStatusIsUpdated()
	{
		 loginpage= new LoginPage(driver);
		 loginpage.login();
		 manageorderpage= new ManageOrderPage(driver);
		 manageorderpage.clickOnManageOrder();
		 manageorderpage.searchAnOrder();
		 String actualStatus= manageorderpage.checkCurrentDeliveryStatus();
		 String expectedStatus= "DELIVERED";
		 Assert.assertEquals(actualStatus, expectedStatus);
	}
	 
		 
	 

}
