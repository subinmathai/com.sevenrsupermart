package com.sevenrmartsupermarket.tests;



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
	 }
	 @Test
	 
	 public void verifyUserSearch()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 adminuserspage.searchAUser("Subi");

	 }
	 @Test
	 public void verifyDeactivateUsers()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 adminuserspage.deactivateUser("admin123**Marlon");
	 }
	 @Test
	 public void verifyEditUsers()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 adminuserspage.editUsers("admin123**Marlon");
	 }
	 @Test
	 public void verifyStatusOfUsers()
	 {
		 loginpage= new LoginPage(driver);
		 adminuserspage= new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserspage.clickOnAdminUsers();
		 System.out.println(adminuserspage.getStatusOfUsers("admin123**Marlon"));// 
	 }
}
