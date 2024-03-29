package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath = "//input[@class='form-control'][1]")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement loginButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement invalidAlert;
	@FindBy(xpath = "//label[contains(text(),'Remember')]")
	private WebElement rememberMe;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMeCheckbox;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void login(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}
	public void login()   // method overloading 
	{
		String userName=properties.getProperty("userName");
		String password=properties.getProperty("password");
		login(userName,password);  // can call login methode one by one	
		
	}
	public String loginFailedAlert()
	{
	
		return invalidAlert.getText();
	}
	public String getRememberMeText()
	{
		return rememberMe.getText();
	}
	
	public boolean isSelectedRememberMeCheckBox()
	{
		rememberMe.click();
		return rememberMeCheckbox.isSelected();
	}
}
