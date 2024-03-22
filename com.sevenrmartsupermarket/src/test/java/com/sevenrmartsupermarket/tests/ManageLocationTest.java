package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.Dataprovider;

public class ManageLocationTest extends Base {
	LoginPage loginpage;
	ManageLocationPage managelocationpage;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void verifyAllFieldsMandatory() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationLink();
		managelocationpage.clickOnNew();
		managelocationpage.getLocationPlaceHolderValue();
		softAssert.assertTrue(managelocationpage.isCountryFieldMandatory());
		softAssert.assertTrue(managelocationpage.isStateFieldMandatory());
		softAssert.assertTrue(managelocationpage.isLocationFieldMandatory());
		softAssert.assertTrue(managelocationpage.isStateFieldMandatory());
		softAssert.assertTrue(managelocationpage.isDeliveryChargeFieldMandatory());
	}
	@Test
	public void verifyLocationFieldPlaceHolderValue()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationLink();
		managelocationpage.clickOnNew();
		Assert.assertEquals(managelocationpage.getLocationPlaceHolderValue(),"Enter the Location");
	}
   @Test
   public void verifyDeliveryChargeFieldPlaceHolderValue()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationLink();
		managelocationpage.clickOnNew();
		Assert.assertEquals(managelocationpage.getDeliveryChargePlaceHolderValue(),"Enter the Delivery Charge");
	}
   @Test
  public void verifyAllFieldsLabelsNames()
  {
	    loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationLink();
		managelocationpage.clickOnNew();
		List<String>actualList=managelocationpage.get_AllFieldLabelNames();
		List<String>expectedList= new ArrayList<String>();
		expectedList.add("Country");
		expectedList.add("State");
		expectedList.add("Location");
		expectedList.add("Delivery Charge");
		Assert.assertEquals(actualList, expectedList);	
  }
   @Test(dataProvider = "data", dataProviderClass = Dataprovider.class)
   public void verifySaveNewLOcation(String location,String Charge)
   {
	   loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationLink();
		managelocationpage.clickOnNew();
		managelocationpage.selectCountry(1);
		managelocationpage.selectState(5);
		managelocationpage.enterLocation(location);
		managelocationpage.enterDeliveryCharge(Charge);
		managelocationpage.clickOnSaveButton();
		Assert.assertEquals(managelocationpage.get_AlertMessage(),"Alert!");
   }
}
