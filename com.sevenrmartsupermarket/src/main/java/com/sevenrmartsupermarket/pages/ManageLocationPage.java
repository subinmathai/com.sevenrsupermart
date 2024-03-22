package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ExcelUtility;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	PageUtility pageutility= new PageUtility(driver);
	ExcelUtility excelUtility= new ExcelUtility();
	@FindBy(xpath = "//p[text()='Manage Location']")
	private WebElement manageLocationLink;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement countryField;
	@FindBy(xpath = "//select[@id='st_id']")
	private WebElement stateField;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']")
	private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//form//label")
	List<WebElement>fieldList;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alert;
	
	
	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		 Properties properties = new Properties();
		PageFactory.initElements(driver, this);
		  try {
	            FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);// initialisation
	            properties.load(fi);

	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	}
	public void clickOnManageLocationLink()
	{
		manageLocationLink.click();
	}
	public void clickOnNew()
	{
		newButton.click();
	}
	public boolean isCountryFieldMandatory()
	{
		boolean countryFieldStatus=Boolean.parseBoolean(countryField.getAttribute("required"));
		return countryFieldStatus;
	}
	public boolean isStateFieldMandatory()
	{
		boolean stateFieldStatus=Boolean.parseBoolean(stateField.getAttribute("required"));
		return stateFieldStatus;
	}
	public boolean isLocationFieldMandatory()
	{
		boolean locationFieldStatus= Boolean.parseBoolean(locationField.getAttribute("required"));
		return locationFieldStatus; 
	}
	public boolean isDeliveryChargeFieldMandatory()
	{
		boolean deliveryStatusFieldStatus=Boolean.parseBoolean(deliveryChargeField.getAttribute("required"));
		return deliveryStatusFieldStatus ;
	}
	public String getLocationPlaceHolderValue()
	{
		return locationField.getAttribute("placeholder");
		
	}
	public String getDeliveryChargePlaceHolderValue()
	{
		return deliveryChargeField.getAttribute("placeholder");
		
	}
	public List<String>get_AllFieldLabelNames()
	{
		GeneralUtility generalUtility= new GeneralUtility();
		List<String>fieldsNames= new ArrayList<String>();
		fieldsNames=generalUtility.getTestofElements(fieldList);
		return fieldsNames;
	}
	public void selectCountry(int index)
	{
		pageutility=new PageUtility(driver);
        pageutility.select_ByIndex(countryField,index);
	}
	public void selectState(int index)
	{
		pageutility=new PageUtility(driver);
        pageutility.select_ByIndex(stateField,index);
	}
	public void enterLocation(String location)
	{
		locationField.sendKeys(location);
	}
   public void enterDeliveryCharge(String charge)
   {
	   deliveryChargeField.sendKeys(charge);
   }
   public void clickOnSaveButton()
	{
		PageUtility pageutility= new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}
   public String get_AlertMessage()
   {
	   return alert.getText();
   }
   }
