package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalutility= new GeneralUtility();

	List<String>usersNames=new ArrayList<String>();
	
	
	@FindBy (xpath="//p[text()='Admin Users'][1]")
	private WebElement adminUsersLink;
	@FindBy (xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	@FindBy (xpath="//select[@id='user_type']")
	private WebElement userType;
	@FindBy (xpath="//button[@name='Create']")
	private WebElement savebtn;

	@FindBy (xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy (xpath="//input[@id='un']")
	private WebElement userNameSearchField;
	@FindBy (xpath="//i[@class='fa fa-search']")
	private WebElement searchingKey;
	@FindBy (xpath="//h5[text()=' Alert!']")
	private WebElement alert;
	@FindBy (xpath="//table/tbody/tr/td[1]")
	private List<WebElement> personsName;
	@FindBy (xpath="//table/tbody/tr[1]/td[1]")
	private WebElement searchNameResult;
	@FindBy (xpath="//h5[text()=' Alert!']")
	private WebElement deactivatedAlertMessage;
	@FindBy (xpath="//button[contains(text(),' Update')]")
	private WebElement updateButton;
	@FindBy (xpath="//h5[text()=' Alert!']")
	private WebElement updatedAlertMessage;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAdminUsers()
	{
		adminUsersLink.click();
	}
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void enterUserName(String username)
	{
		userName.sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void SelecterUserType(String user)
	{
		Select select= new Select(userType);
		select.selectByVisibleText("Admin");
	}
	public void clickOnSave()
	{
		savebtn.click();
	}
	public String getNewUsercreatedAlertMessage()
	{
		return alert.getText();
	}
	public void createNewUser(String username, String pwd, String userType)
	{
		clickOnAdminUsers();
		clickOnNewButton();
		enterUserName(username);
		enterPassword(pwd);
		SelecterUserType(userType);
		clickOnSave();
	}
	public void clickOnsearchButton()
	{
		searchButton.click();	
	}
	public void searchUser(String username)
	{
		clickOnsearchButton();
		userNameSearchField.sendKeys(username);
		searchingKey.click();
	}
	public String searchUserNameResult()
	{
		
		return searchNameResult.getText();
	}
	public String deactivateUser(String person)
	{
		List<String> names=new ArrayList<String>();
		names= generalutility.getTestofElements(personsName);
		int index=0;
		for(index=0;index<names.size();index++)
		{
			if(person.equals(names.get(index)))
					{
				index++;
				break;
					}
		}
		
		WebElement unlock= driver.findElement(By.xpath("//table/tbody/tr["+index+"]//td[5]//a[1]"));
		unlock.click();
		return (deactivatedAlertMessage.getText());
			
	}
	public String ClickOnUserEditButton(String name)
	{
		List<String> names=new ArrayList<String>();
		names= generalutility.getTestofElements(personsName);
		int index=0;
		for(index=0;index<names.size();index++)
		{
			if(name.equals(names.get(index)))
					{
				index++;
				break;
					}
		}
		
		WebElement edit= driver.findElement(By.xpath("//table/tbody/tr["+index+"]//td[5]//a[2]"));
		edit.click();
		WebElement posistionelements= driver.findElement(By.xpath("//table//tbody/tr["+index+"]//td[1]"));
		return (posistionelements.getText());
	}
	public String UpdateUserDetails(String name)
	{
		ClickOnUserEditButton(name);
		updateButton.click();
		return updatedAlertMessage.getText();
	}
	public boolean checkUserNameMandatoty()
	{
		boolean username = Boolean.parseBoolean(userName.getAttribute("required"));
		return username;
	}
	public boolean checkPasswordMandatoty()
	{
		boolean pwd = Boolean.parseBoolean(password.getAttribute("required"));
		return pwd;
	}
}
