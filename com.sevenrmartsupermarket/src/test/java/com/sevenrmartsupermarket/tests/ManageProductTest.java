package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	LoginPage loginpage;
	ManageProductPage manageproductpage;
	@Test
	public void clickOnManageProductLink()
	{
		loginpage= new LoginPage(driver);
		manageproductpage= new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.clickOnManageProductLink();
	}
	@Test
	public void verifyProductStatusChange()
	{
		loginpage= new LoginPage(driver);
		manageproductpage= new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.clickOnManageProductLink();
		String actualStatus=manageproductpage.changeProductStatus("Veg");
		String expectedStatus="Active";
		Assert.assertEquals(actualStatus , expectedStatus);
	}
	@Test
    public void verifyEditProduct()
    {
    	loginpage= new LoginPage(driver);
		manageproductpage= new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.clickOnManageProductLink();
		manageproductpage.clickEditProductDetails("Veg");
    }
}
