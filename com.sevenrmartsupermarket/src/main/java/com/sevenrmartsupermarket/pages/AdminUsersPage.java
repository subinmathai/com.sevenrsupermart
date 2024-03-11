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
	WebElement adminUsersLink;
	@FindBy (xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy (xpath="//input[@id='username']")
	WebElement userName;
	@FindBy (xpath="//input[@id='password']")
	WebElement password;
	@FindBy (xpath="//select[@id='user_type']")
	WebElement userType;
	@FindBy (xpath="//button[@name='Create']")
	WebElement savebtn;

	@FindBy (xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy (xpath="//input[@id='un']")
	WebElement userNameSearchField;
	@FindBy (xpath="//i[@class='fa fa-search']")
	WebElement searchingKey;
	@FindBy (xpath="//table/tbody/tr/td[1]")
	List<WebElement> personsName;
	
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
	public void createNewUser(String username, String pwd, String userType)
	{
		clickOnAdminUsers();
		clickOnNewButton();
		enterUserName(username);
		enterPassword(pwd);
		SelecterUserType(userType);
		clickOnSave();
	}
	public void searchAUser(String username)
	{
		searchButton.click();
		userNameSearchField.sendKeys(username);
		searchingKey.click();
		
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
		WebElement posistionelements= driver.findElement(By.xpath("//table//tbody/tr["+index+"]//td[1]"));
		return (posistionelements.getText());
			
	}
	public String editUsers(String name)
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
	public String getStatusOfUsers(String name)
	{
		List<String>names=new ArrayList<String>();
		names=generalutility.getTestofElements(personsName);
		int index=0;
		for(index=0;index<names.size();index++)
		{
			if(name.equals(names.get(index)))
			{
				index++;
				break;
			}
		}
		WebElement status= driver.findElement(By.xpath("//table/tbody/tr["+index+"]//td[3]"));
		return (status.getText());
		
		
	}
	

}
