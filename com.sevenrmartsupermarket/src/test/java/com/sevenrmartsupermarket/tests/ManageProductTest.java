package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	LoginPage loginpage;
	ManageProductPage manageproductpage;
	@Test
	public void verifyclickOnManageProductLink()
	{
		loginpage= new LoginPage(driver);
		manageproductpage= new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.clickOnManageProductLink();
		String actualHeading=manageproductpage.get_PageHeading();
		Assert.assertEquals(actualHeading, "List Products");
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
    public void verifyEditProductButton()
    {
    	loginpage= new LoginPage(driver);
		manageproductpage= new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.clickOnManageProductLink();
		manageproductpage.clickEditProductDetails("Veg");
		Assert.assertEquals(manageproductpage.get_EditPageHeading(), "Edit Product");
		
    }
}
