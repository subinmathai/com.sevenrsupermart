package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalutility= new GeneralUtility();
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
	@FindBy (xpath="//h5[text()=' Alert!']")
	private WebElement savedAlertMessage;
	@FindBy(xpath = "//form//div/label")
	private List<WebElement> fielsList;
	@FindBy(xpath = "//table/tbody/tr//td[1]")
	private List<WebElement> deliveryBoyNameList;
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
		PageUtility pageutility= new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}
	public String get_SaveAlert()
	{
		return savedAlertMessage.getText();
	}
	public void saveNewDeliveryBoy(String name,String emailid,String phn,String add,String username,String pwd)
	{
		clickOnNew();
		enterName(name);
		enterEmailid(emailid);
		enterPhoneNumber(phn);
		enterAddress(add);
		enterUserName(username);
		enterPassword(pwd);
		clickOnSave();
	}
	public List<String> printAllFieldsNames()
	{
		GeneralUtility generalutility= new GeneralUtility();
		List<String> allFields=new ArrayList<String>();
		allFields=generalutility.getTestofElements(fielsList);
	    return allFields;
    }
	
		
}
