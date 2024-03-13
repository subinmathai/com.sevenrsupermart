package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;

public class ManageExpenseTest extends Base {
	LoginPage loginpage;
	ManageExpensePage manageexpensepage;
	@Test
public void verifyMangeExpenseoptionsList()
{
	loginpage= new LoginPage(driver);
	manageexpensepage= new ManageExpensePage(driver);
	loginpage.login();
	manageexpensepage.clickOnManageExpensePageLink();
	List<String> actualOptions= manageexpensepage.get_manageexpenseOption();
	List<String> expectedOptions=new ArrayList<String>();
	expectedOptions.add("Expense Category");
	expectedOptions.add("Manage Expense");
	Assert.assertEquals(actualOptions, expectedOptions);
}
	@Test
 public void verifyExpenseCategoryOptionClick()
 {
	    loginpage= new LoginPage(driver);
		manageexpensepage= new ManageExpensePage(driver);
		loginpage.login();
		manageexpensepage.clickOnManageExpensePageLink();
		manageexpensepage.clickOnManageCategoruoption();
		String actualTitle=manageexpensepage.get_TitleOfExpenseCategoryPage();
		String ExpectedTitle="Expense Category";
		Assert.assertEquals(actualTitle, ExpectedTitle);
 }
	@Test
	public void verifyExpenseCategoryEdit()
	{
		loginpage= new LoginPage(driver);
		manageexpensepage= new ManageExpensePage(driver);
		loginpage.login();
		manageexpensepage.clickOnManageExpensePageLink();
		manageexpensepage.clickOnManageCategoruoption();
		manageexpensepage.editExpenseCategory("apple");
	}
	@Test
	public void verifyAddNewExpense()
	{
		loginpage= new LoginPage(driver);
		manageexpensepage= new ManageExpensePage(driver);
		loginpage.login();
		manageexpensepage.createNewExpense("1000");
		String ActualAlert=manageexpensepage.getAlertMessage();
		String ExpectedAlert="Alert!";
		Assert.assertEquals(ActualAlert, ExpectedAlert);
		
	}
}
