package com.sevenrmartsupermarket.tests;

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
		 manageorderpage.SearchButtonClick();
		 manageorderpage.enterOrderid("126");
		 manageorderpage.ClickonsearchListOrder();
		 manageorderpage.changeStatusbuttonClick();
		 manageorderpage.selectDeliveryStatus();
		 
		 
		 
	 }

}
