package com.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.Baseclass;
import com.pages.Loginapp;
import com.utility.ExcelDataProvider;
import com.utility.Helper;


public class Logintest extends Baseclass
{
	
	
	@Test(priority=1)
	public void bcqamlogin()
	{
		logger=report.createTest("Login into BCQAM");
		Loginapp lgnapp=PageFactory.initElements(driver, Loginapp.class);
		logger.info("Started application");
		lgnapp.logintobcqam(excel.getStringdata("Login", 0, 0),excel.getStringdata("Login", 0, 1));
		logger.pass("login success");
	
	}
	@Test(priority=2)
	public void bcqamlogout()
	{
		logger=report.createTest("Logout");
		logger.fail("logout fail");
	
	}
}
