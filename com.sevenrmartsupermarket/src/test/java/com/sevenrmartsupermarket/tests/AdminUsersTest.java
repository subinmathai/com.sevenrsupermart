package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	 LoginPage loginpage;
	 HomePage homepage;
	 AdminUsersPage adminuserspage;
	 
	@Test
	 public void verifyNewUserCreation()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 String uname=GeneralUtility.get_RandomFirstName();
		 adminuserspage.createNewUser("Subi"+uname,"123","Admin");
		 System.out.println(GeneralUtility .get_RandomFirstName());//to avoid dulication this create differentname
		 String actualAlertMessage=adminuserspage.getNewUsercreatedAlertMessage();
		 String expectedAlertMessage="Alert!";
		 Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	 }
	 @Test
	 public void verifyUserSearch()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 adminuserspage.searchUser("Subi");
		 String actualName=adminuserspage.searchUserNameResult();
		 String expectedName= "subi";
		 Assert.assertEquals(actualName, expectedName);
	 }
	 @Test
	 public void verifyActivateOrDeactivateUsers()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 String actualAlertMessage =adminuserspage.deactivateUser("Carisa");
		 String expectedAlertMessage="Alert!";
		 Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		 
	 }
	 @Test
	 public void verifyEditUsers()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 String actualAlertMessage=adminuserspage.UpdateUserDetails("Carisa");
		 String expectedAlertMessage="Alert!";
		 Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	 }
	 @Test
	 public void verifyUserNameFieldIsMandatory()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.createNewUser("","123","Admin"); 
		 Assert.assertEquals(adminuserspage.checkUserNameMandatoty(),true);
	 }
	 @Test
	 public void VerifyPasswordFieldIsMandatory()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.createNewUser("","123","Admin"); 
		 Assert.assertEquals(adminuserspage.checkPasswordMandatoty(),true);
	 }
	 
}
