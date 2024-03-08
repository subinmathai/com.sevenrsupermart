package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	WebElement pushnotification;
	@FindBy(xpath = "//input[@id='title']")
	WebElement PushNotificationTitle;
	@FindBy(xpath = "//input[@id='description']")
	WebElement PushNotificationDescription;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement sendbutton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;
	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPushNotification()
	{
		pushnotification.click();
	}
	public void enterTitleField(String title)
	{
		PushNotificationTitle.sendKeys(title);
	}
	public void enterDescriptionField(String description)
	{
		PushNotificationDescription.sendKeys(description);
	}
	public void SendButton()
	{
		sendbutton.click();
	}
	
	public String getAlertMessageText()
	{
		return alertMessage.getText();
	}
	
}
