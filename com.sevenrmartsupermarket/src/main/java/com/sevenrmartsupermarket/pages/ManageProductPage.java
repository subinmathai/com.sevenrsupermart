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

public class ManageProductPage {
	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();

	@FindBy(xpath = "//p[text()='Manage Product']")
	private WebElement manageProductLink;
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> titlesNames;
	@FindBy(xpath = "//h1[text()='List Products']")
	private WebElement pageHeading;
	@FindBy(xpath = "//h1[text()='Edit Product']")
	private WebElement editPageHeading;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageProductLink() {
		manageProductLink.click();
	}
	public String get_PageHeading()
	{
		return pageHeading.getText();
	}

	public String changeProductStatus(String productType) {
		PageUtility pageutility = new PageUtility(driver);
		List<String> productnames = new ArrayList<String>();
		productnames = generalutility.getTestofElements(titlesNames);
		int index = 0;
		for (index = 0; index < productnames.size(); index++) {
			if (productType.equals(productnames.get(index))) {
				index++;
				break;
			}
		}

		WebElement status = driver.findElement(By.xpath("//table/tbody/tr[" + index + "]//td[7]//a[1]"));
		pageutility.scrollAndClick(status);
		WebElement posistionelements = driver.findElement(By.xpath("//table/tbody/tr[" + index + "]/td[7]/a/span"));
		return (posistionelements.getText());
	}

	public void clickEditProductDetails(String productType) {
		PageUtility pageutility = new PageUtility(driver);
		List<String> productnames = new ArrayList<String>();
		productnames = generalutility.getTestofElements(titlesNames);
		int index = 0;
		for (index = 0; index < productnames.size(); index++) {
			if (productType.equals(productnames.get(index))) {
				index++;
				break;
			}
		}
		WebElement edit = driver.findElement(By.xpath("//table/tbody/tr[" + index + "]/td[9]/a[1]"));
		pageutility.scrollAndClick(edit);

	}
	public String get_EditPageHeading()
	{
		return editPageHeading.getText();
	}

}