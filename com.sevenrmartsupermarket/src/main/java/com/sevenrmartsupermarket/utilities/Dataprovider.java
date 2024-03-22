package com.sevenrmartsupermarket.utilities;

import java.util.Set;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	ExcelUtility excelUtility= new ExcelUtility();
	@DataProvider(name="Items")
	
	public Object[][] exceldata() 
	{
		excelUtility.setExcelFile("LoginData", "LoginCredentials");
		Object data[][]=excelUtility.getMultidimentionalData(2, 2);
		return data;
	}
	@DataProvider(name="data")
	public Object[][] dataOfManageLocation() 
	{
		excelUtility.setExcelFile("ManageLocationData", "Data");
		Object data[][]=excelUtility.getMultidimentionalData(1, 2);
		return data;
	}

}
