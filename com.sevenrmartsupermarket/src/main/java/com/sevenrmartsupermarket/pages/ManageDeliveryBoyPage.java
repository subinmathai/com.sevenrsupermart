package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'][1]")
	private WebElement manageDeliveryBotBtn;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressfield;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNamefield;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageDeliveryBoyButton()
	{
		manageDeliveryBotBtn.click();
	}
	public void clickOnNew()
	{
		newButton.click();
	}
	public void enterName(String name)
	{
	  nameField.sendKeys(name);	
	}
	public void enterEmailid(String emailid)
	{
		emailField.sendKeys(emailid);
	}
	public void enterPhoneNumber(String phn)
	{
		phoneNumberField.sendKeys(phn);
	}
	public void enterAddress(String add)
	{
		addressfield.sendKeys(add);
	}
	public void enterUserName(String username)
	{
		userNamefield.sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		passwordfield.sendKeys(pwd);
	}
	public void clickOnSave()
	{
		saveButton.click();
	}
	public void createNewDeliveryBoy(String name,String emailid,String phn,String add,String username,String pwd)
	{
		PageUtility pageutility= new PageUtility(driver);
		clickOnNew();
		enterName(name);
		enterEmailid(emailid);
		enterPhoneNumber(phn);
		enterAddress(add);
		enterUserName(username);
		enterPassword(pwd);
		pageutility.scrollAndClick(saveButton);
		
	}
}
