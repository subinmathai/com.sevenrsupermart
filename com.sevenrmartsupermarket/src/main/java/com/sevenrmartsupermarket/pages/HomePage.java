package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	private WebElement profileName;
	@FindBy(xpath = "//li[text()='Dashboard']")
	private WebElement pageName;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement defaultPageName;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement shopName;
	@FindBy(xpath = "//img[@class='brand-image img-circle elevation-3']")
	private WebElement shopLogo;
	@FindBy(xpath = "//section//div/p")
	private List<WebElement> iconslist;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getProfileName()
	{
		return profileName.getText();
	}
	public String getPageName()
	{
		return pageName.getText();
	}
	public String getDefaultPageName()
	{
		return defaultPageName.getText();
	}
	public String getShopName()
	{
		return shopName.getText();
	}
	public boolean isDisplayedLogo()
	{
		return shopLogo.isDisplayed();
	}
	public List<String> printAllIconsNames()
	{
		GeneralUtility generalutility= new GeneralUtility();
		List<String> iconsName=new ArrayList<String>();
		iconsName=generalutility.getTestofElements(iconslist);
	    return iconsName;
}
}