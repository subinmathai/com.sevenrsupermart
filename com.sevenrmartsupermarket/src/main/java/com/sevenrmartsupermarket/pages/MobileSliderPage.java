package com.sevenrmartsupermarket.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class MobileSliderPage {
WebDriver driver;
PageUtility pageutility= new PageUtility(driver);

@FindBy(xpath = "//p[text()='Mobile Slider']")
WebElement mobileSilderLink;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
WebElement newButton;
@FindBy(xpath = "//select[@id='cat_id']")
WebElement categoryDropDown;
@FindBy(xpath = "//select[@id='cat_id']//option")
WebElement categoryOptions;
@FindBy(xpath = "//input[@id='main_img']")
WebElement chooseFileButton;
@FindBy(xpath = "//button[text()='Save']")
WebElement saveButton;

public MobileSliderPage(WebDriver driver)
{
	this.driver=driver;
    PageFactory.initElements(driver, this);
	
}
public void clickOnMobileSliderLink()
{
	mobileSilderLink.click();
}
public void clickOnNew()
{
	newButton.click();
}
public void selectCategory()
{   
	categoryDropDown.click();
	//String categoryoption="Fruits";
	//WebElement categoryOptions= driver.findElement(By.xpath("//option[text()='"+categoryoption+"']"));
	 pageutility.select_ByIndex(categoryDropDown,3);
	 pageutility.scrollAndClick(categoryDropDown);
}
public void imageFileUpload()
{
	
	File file= new File(Constants.SCREENSHOT_FILEPATH);
	chooseFileButton.sendKeys(Constants.SCREENSHOT_FILEPATH+"Productimage.png");
}

public void saveNewMobileSilderInformation()
{
	clickOnNew();
	selectCategory();
	imageFileUpload();
	saveButton.click();
}
}
