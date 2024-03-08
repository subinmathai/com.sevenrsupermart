package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement profileName;
	@FindBy(xpath = "//li[text()='Dashboard']")
	WebElement pageName;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement defaultPageName;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement shopName;
	@FindBy(xpath = "//img[@class='brand-image img-circle elevation-3']")
	WebElement shopLogo;
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
}
