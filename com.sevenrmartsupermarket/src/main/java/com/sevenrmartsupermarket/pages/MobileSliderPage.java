package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class MobileSliderPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility(driver);

	@FindBy(xpath = "//p[text()='Mobile Slider']")
	private WebElement mobileSilderLink;
	@FindBy(xpath = "//h1[text()='List Mobile Sliders']")
	private WebElement mobileSilderPageTitle;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryDropDown;
	@FindBy(xpath = "//select[@id='cat_id']//option")
	private WebElement categoryOptions;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileButton;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alerMessage;
	@FindBy(xpath = "//form//div/label")
	private List<WebElement>fieldNames;
	
	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMobileSliderLink() {
		mobileSilderLink.click();
	}
    public String get_MobileSliderPageTitle()
   {
	 return mobileSilderPageTitle.getText();
   }
	public void clickOnNew() {
		newButton.click();
	}

	public void selectCategory() {
		categoryDropDown.click();
		pageutility.select_ByIndex(categoryDropDown, 3);
		pageutility.scrollAndClick(categoryDropDown);
	}

	public void imageFileUpload() {

		File file = new File(Constants.SCREENSHOT_FILEPATH);
		chooseFileButton.sendKeys(Constants.SCREENSHOT_FILEPATH + "Productimage.png");
	}
	public void clickOnSave()
	{
		saveButton.click();
	}
	public String get_AlertMessage()
	{
		
	return alerMessage.getText();
		
	}

	public void saveNewMobileSilderInformation() {
		clickOnNew();
		selectCategory();
		imageFileUpload();
		clickOnSave();
	}
	public List<String> get_AllFieldAddMobileSlider()
	{
		GeneralUtility generalutility= new GeneralUtility();
		List<String>allFieldNames= new ArrayList<String>();
		allFieldNames= generalutility.getTestofElements(fieldNames);
		return allFieldNames;
	}
}
