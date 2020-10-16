package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import freemarker.template.SimpleDate;

public class Helper 
{

	//Screenshot,alerts,frames,windowhandles,javascript execut 
	
	public static String capturescreenshot(WebDriver driver)
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/BCQAM_"+getcurrentDateTame()+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("screenshot captured");
		} 
		catch (Exception e) 
		{
			System.out.println("unable to capture screenshot:"+e.getMessage());
		}
		return screenshotpath;
	}
	
	public static String getcurrentDateTame()
	{
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");
		Date date=new Date();
		return customformat.format(date);
	}
	
}
