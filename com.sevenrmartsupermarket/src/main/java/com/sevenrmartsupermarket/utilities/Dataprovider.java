package com.sevenrmartsupermarket.utilities;

import java.util.Set;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	Excel excel= new Excel();
	@DataProvider(name="Items")
	
	public Object[][] exceldata() 
	{
		excel.setExcelFile("LoginData", "LoginCredentials");
		Object data[][]=excel.getMultidimentionalData(2, 2);
		return data;
	}

}
