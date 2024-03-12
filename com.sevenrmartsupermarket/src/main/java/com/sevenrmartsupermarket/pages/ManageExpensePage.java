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

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility generalutility= new GeneralUtility();
	PageUtility pageutility= new PageUtility(driver);
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview'][1]")
	WebElement manageExpenseLink;
	@FindBy(xpath = "//ul/li[4]/ul/li")
	List<WebElement> options;
	@FindBy(xpath = "//li/a[@href=\"https://groceryapp.uniqassosiates.com/admin/expense-category\"]")
	WebElement expenceCategoryOption;
	@FindBy(xpath = "//h1[text()='Expense Category']")
	WebElement expenceCategoryPageTitle;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	List<WebElement> expenseCategoryTitle;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement expenseCategoryUpadateButton;
	public ManageExpensePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageExpensePageLink()
	{
	   manageExpenseLink.click();	
	}
	public List<String> get_manageexpenseOption()
	{
		GeneralUtility generalutility= new GeneralUtility();
		List<String> optionsList=new ArrayList<String>();
		optionsList=generalutility.getTestofElements(options);
	    return optionsList;
    }
    public void clickOnManageCategoruoption()
    {
    	expenceCategoryOption.click();
    }
    public String get_TitleOfExpenseCategoryPage()
    {
    	return expenceCategoryPageTitle.getText();
    }
    public String editExpenseCategory(String titleName)
    {
    	
		List<String> Alltitles=new ArrayList<String>();
		Alltitles= generalutility.getTestofElements(expenseCategoryTitle);
		int index=0;
		for(index=0;index<Alltitles.size();index++)
		{
			if(titleName.equals(Alltitles.get(index)))
					{
				index++;
				break;
					}
		}
		WebElement edit= driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[2]/a[1]"));
		pageutility.scrollAndClick(edit);
		return edit.getText();
    }
    public void updateExpenseCategory()
    {
    	pageutility.scrollAndClick(expenseCategoryUpadateButton);
    }

}
