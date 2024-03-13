package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOrderPage {
	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	PageUtility pageutility = new PageUtility(driver);
	List<String> listOption = new ArrayList<String>();

	@FindBy(xpath = "//p[text()='Manage Orders']")
	private WebElement manageorderbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='od']")
	private WebElement orderIdField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searching;
	@FindBy(xpath = "//table/tbody/tr[1]//td[6]//a[1]")
	private WebElement changeStatus;
	@FindBy(xpath = "//select[@id='status']")
	private WebElement deliveryStatusList;
//List<String> options=new ArrayList<String>();
	@FindBy(xpath = "//div[contains(text(),'Update')]")
	private WebElement updateLabel;
	@FindBy(xpath = "//button[@name='Update_st'][1]")
	private WebElement updateButton;
	@FindBy(xpath = "//table/tbody/tr/td[6]/span[1]")
	private WebElement newStatus;

	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOrder() {
		manageorderbutton.click();
	}

	public void SearchButtonClick() {
		searchButton.click();
	}

	public void enterOrderid(String id) {
		orderIdField.sendKeys(id);
	}

	public void ClickonsearchListOrder() {

		searching.click();
	}

	public void searchAnOrder() {
		SearchButtonClick();
		enterOrderid("126");
		ClickonsearchListOrder();
	}

	public void changeStatusbuttonClick() {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(changeStatus);

	}

	public void selectDeliveryStatus() {
		// Actions actions= new Actions(driver);
		changeStatusbuttonClick();
		PageUtility pageUtility = new PageUtility(driver);
		deliveryStatusList.click();
		pageUtility.select_ByIndex(deliveryStatusList, 3);
		// actions.contextClick().build().perform();
		// updateLabel.click();
		// updateButton.click();
		pageUtility.scrollAndClick(deliveryStatusList);
	}

	public String checkCurrentDeliveryStatus() {
		return newStatus.getText();
	}

}
