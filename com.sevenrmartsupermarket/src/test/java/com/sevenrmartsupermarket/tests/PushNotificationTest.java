package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.Excel;

public class PushNotificationTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	PushNotificationPage pushnotificationpage;
	Excel excel = new Excel();
	@Test

	public void verifyPushNotificationMessage()
	{
		loginpage = new LoginPage(driver);
		homepage= new HomePage(driver);
		pushnotificationpage= new PushNotificationPage(driver);
		loginpage.login();
		pushnotificationpage.clickOnPushNotification();
		
		excel.setExcelFile("PushNotificationData","Notification"); // excelworkbookname and sheet name
		String title=excel.getCellData(0, 0);   // title data position
		String description=excel.getCellData(0, 1);// description position
		pushnotificationpage.enterTitleField(title);
		pushnotificationpage.enterDescriptionField(description);
		pushnotificationpage.SendButton();
		System.out.println(pushnotificationpage.getAlertMessageText());
		String actualAlert=pushnotificationpage.getAlertMessageText();
		String expectedalert="Alert!";
		Assert.assertEquals(actualAlert, expectedalert);
	}
	

}
