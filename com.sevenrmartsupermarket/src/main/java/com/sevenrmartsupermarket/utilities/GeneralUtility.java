package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public List<String>getTestofElements(List<WebElement>elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element : elements)
		{ 
			data.add(element.getText());
		}
		return data;
	}
	public String get_Attribute(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	public String get_CssValue(WebElement element,String cssproperties)
	{
		return element.getCssValue(cssproperties);
	}
	public static String get_RandomFirstName()
	{
		Faker faker= new Faker();
		return faker.name().firstName();
	}
	public String getTabTitle(WebDriver driver) {
		return (driver.getTitle());
	}
	
}
