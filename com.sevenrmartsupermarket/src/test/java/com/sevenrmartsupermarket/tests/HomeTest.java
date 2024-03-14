package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base{
	 LoginPage loginpage;
	 HomePage homepage;
	
	 @Test(groups={"grp1","grp2"})
	 public void verifyPageName()
	 {
		 loginpage= new LoginPage(driver);
		 homepage= new HomePage(driver);
		 loginpage.login();
		 String actualResult=homepage.getDefaultPageName()+homepage.getPageName();
		 String expectedResult="HomeDashboard";
		 Assert.assertEquals(actualResult, expectedResult);
	 }
	 @Test(groups = "regression")
	 public void verifyShopName()
	 {
		 loginpage= new LoginPage(driver);
		 homepage= new HomePage(driver);
		 loginpage.login();
		 String actualResult=homepage.getShopName();
		 String expectedResult="7rmart supermarket";
		 Assert.assertEquals(actualResult, expectedResult);
	 }
	 @Test
	 public void verifyLogoIsDisplayed()
	 {
		 loginpage= new LoginPage(driver);
		 homepage= new HomePage(driver);
		 loginpage.login();
		 boolean  actualResult=homepage.isDisplayedLogo();
		 Assert.assertTrue(actualResult);
	 }
	 @Test
	 public void verifyAlliconsName()
	 {
		 loginpage= new LoginPage(driver);
		 homepage= new HomePage(driver);
		 loginpage.login();
		 List<String>actualIconsList=homepage.printAllIconsNames();
		 List<String>expextedIconsList= new ArrayList<String>();
		 expextedIconsList.add("Manage Pages");
		 expextedIconsList.add("Admin Users");
		 expextedIconsList.add("Dashboard");
		 expextedIconsList.add("Category");
		 expextedIconsList.add("Manage Product");
		 expextedIconsList.add("Manage Offer Code");
		 expextedIconsList.add("Manage Slider");
		 expextedIconsList.add("Manage Delivery Boy");
		 expextedIconsList.add("Manage Users");
		 expextedIconsList.add("Manage Orders");
		 expextedIconsList.add("Manage Location");
		 expextedIconsList.add("Mobile Slider");
		 expextedIconsList.add("Manage News");
		 expextedIconsList.add("Manage Expense");
		 expextedIconsList.add("Manage Gift cards &vouchers");
		 expextedIconsList.add("Manage Gift cards &vouchers");
		 Assert.assertEquals(actualIconsList, expextedIconsList);
		
		 
	 }

}
