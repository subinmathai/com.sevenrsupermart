package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base{
	LoginPage loginpage;
	 HomePage homepage;
	 @Test(groups={"grp1","grp2"})
	 public void verifyGettext()
	 {

			loginpage= new LoginPage(driver);
			homepage= new HomePage(driver);
			loginpage.login();
	 }
	 @Test(groups = "smoke")
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
	 

}
