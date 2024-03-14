package com.sevenrmartsupermarket.pages;

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

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	PageUtility pageutility = new PageUtility(driver);

	@FindBy(xpath = "//li[@class='nav-item has-treeview'][1]")
	private WebElement manageExpenseLink;
	@FindBy(xpath = "//ul/li[4]/ul/li")
	private List<WebElement> options;
	@FindBy(xpath = "//li/a[@href=\"https://groceryapp.uniqassosiates.com/admin/expense-category\"]")
	private WebElement expenceCategoryOption;
	@FindBy(xpath = "//h1[text()='Expense Category']")
	private WebElement expenceCategoryPageTitle;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> expenseCategoryTitle;
	@FindBy(xpath = "//button[contains(text(),Update)]")
	private WebElement expenseCategoryUpadateButton;
	@FindBy(xpath = "//li/a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-expense\"]")
	private WebElement manageExpenseSubButton;
	@FindBy(xpath = "//a[@onClick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='user_id']")
	private WebElement userIdField;
	@FindBy(xpath = "//input[@class='form-control date']")
	private WebElement dateField;
	@FindBy(xpath = "//select[@id='ex_cat']")
	private WebElement categoryField;
	@FindBy(xpath = "//select[@id='order_id']")
	private WebElement orderidField;
	@FindBy(xpath = "//select[@id='purchase_id']")
	private WebElement purchaseIdField;
	@FindBy(xpath = "//select[@id='ex_type']")
	private WebElement expenseTypeField;
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement amountField;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertMessage;
	@FindBy(xpath = "//input[@name='userfile']")
	private WebElement chooseFile;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageExpensePageLink() {
		manageExpenseLink.click();
	}

	public List<String> get_manageexpenseOption() {
		GeneralUtility generalutility = new GeneralUtility();
		List<String> optionsList = new ArrayList<String>();
		optionsList = generalutility.getTestofElements(options);
		return optionsList;
	}

	public void clickOnManageCategoruoption() {
		expenceCategoryOption.click();
	}

	public String get_TitleOfExpenseCategoryPage() {
		return expenceCategoryPageTitle.getText();
	}

	public void clickOnManageExpensesubButton() {
		manageExpenseSubButton.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void selectUserId() {
		pageutility.select_ByIndex(userIdField, 5);
		pageutility.scrollAndClick(userIdField);
	}

	public void enterDate() {
		dateField.sendKeys("20-03-2024");
	}

	public void selectCategory() {
		pageutility.select_ByVisibleText(categoryField, "Fruits");
		pageutility.scrollAndClick(categoryField);
	}

	public void selectOrderId() {
		pageutility.select_ByIndex(orderidField, 3);
		pageutility.scrollAndClick(orderidField);
	}

	public void selectPurchaseId() {
		pageutility.select_ByIndex(purchaseIdField, 2);
		pageutility.scrollAndClick(purchaseIdField);
	}

	public void selectExpenseType() {
		pageutility.select_ByVisibleText(expenseTypeField, "Debit Cash");
		pageutility.scrollAndClick(categoryField);
	}

	public void enterAmount(String amount) {
		amountField.sendKeys(amount);
	}

	public void uploadFile() {
		chooseFile.sendKeys(Constants.SCREENSHOT_FILEPATH + "Productimage.png");
	}

	public String getAlertMessage() {
		return alertMessage.getText();

	}

	public void createNewExpense(String amount) {
		PageUtility pageutility = new PageUtility(driver);
		manageExpenseLink.click();
		clickOnManageExpensesubButton();
		clickOnNewButton();
		selectUserId();
		enterDate();
		selectCategory();
		selectOrderId();
		selectPurchaseId();
		selectExpenseType();
		enterAmount(amount);
		uploadFile();
		pageutility.scrollAndClick(saveButton);

	}

}
