package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;


public class LoginTest extends Base 
{
 LoginPage loginpage;
 HomePage homepage;
@Test

public void verifyUserLogin()
{
	loginpage= new LoginPage(driver);
	homepage= new HomePage(driver);
	loginpage.login();
    //loginpage.login("admin","admin");
	String expectedProfileName="Admin";
	String actualProfileName=homepage.getProfileName();
	Assert.assertEquals(actualProfileName, expectedProfileName);
}
@Test(groups = "smoke")
public void verifyLoginFailedAlert()
{
	loginpage= new LoginPage(driver);
	homepage= new HomePage(driver);
	loginpage.login("admin","123"); 
	
	String actualAlert=loginpage.loginFailedAlert();
	String ExpectedAlert="Alert!";
	Assert.assertEquals(actualAlert, ExpectedAlert);
	
}
@Test(groups = "regression")
public void verifyRememberMeText()
{
	loginpage= new LoginPage(driver);
	String actualResult= loginpage.getRememberMeText();
	String expectedResult="Remember Me";
	Assert.assertEquals(actualResult, expectedResult);
}
@Test(groups = "smoke")
public void verifyRememberMeISSelected()
{
	loginpage= new LoginPage(driver);
	boolean result=loginpage.isSelectedRememberMe();
	Assert.assertTrue(result);
}
}