package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOrderPage {
WebDriver driver;
GeneralUtility generalutility= new GeneralUtility();
PageUtility pageutility= new PageUtility(driver);
List<String>listOption= new  ArrayList<String>();

@FindBy(xpath = "//p[text()='Manage Orders']")
WebElement manageorderbutton;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
WebElement searchButton;
@FindBy(xpath = "//input[@id='od']")
WebElement orderIdField;
@FindBy(xpath = "//button[@name='Search']")
WebElement searching;
@FindBy (xpath="//table/tbody/tr[1]//td[6]//a[1]")
WebElement changeStatus;
@FindBy(xpath = "//select[@id='status']")
WebElement deliveryStatusList;
//List<String> options=new ArrayList<String>();


public ManageOrderPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnManageOrder()
{
	manageorderbutton.click();
}
public void SearchButtonClick()
{
	searchButton.click();
}
public void enterOrderid(String id)
{
	orderIdField.sendKeys(id);
}
public void ClickonsearchListOrder()
{
	
	searching.click();
}
	
public void changeStatusbuttonClick()
{
	PageUtility pageutility= new PageUtility(driver);
	pageutility.scrollAndClick(changeStatus);
	
}
public void selectDeliveryStatus() {
	PageUtility pageUtility= new PageUtility(driver);
	deliveryStatusList.click();
	pageUtility.select_ByIndex(deliveryStatusList, 1);
	
	
	
	
}
}


