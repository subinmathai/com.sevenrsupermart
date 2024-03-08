package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sevenrmartsupermarket.constants.Constants;
import org.openqa.selenium.io.FileHandler;
public class ScreenShot {
static TakesScreenshot takescreenshot;
public static void takeScreenShot(WebDriver driver, String imageName)
{
	try {
		takescreenshot=(TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		String destination=Constants.SCREENSHOT_FILEPATH+imageName+"-"+timeStamp+".png";
		File finalDestination= new File(destination);
		FileHandler.copy(screenshot, finalDestination);
		
		
	} catch (Exception e) {
		e.getStackTrace();
	}
}
}
