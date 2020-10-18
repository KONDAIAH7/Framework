package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.Browserfactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class Baseclass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite()
	{
		Reporter.log("Setting up report and test is ready", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/BCQAM"+Helper.getcurrentDateTame()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("setting is done and test started", true);
		
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void startup(String browser)
	
	{
		Reporter.log("Try to start browser", true);
		//driver=Browserfactory.startapplication(driver, config.getBrowser(),config.getStagingURL());
		driver=Browserfactory.startapplication(driver, browser, config.getStagingURL());
		Reporter.log("browser and application start running", true);
	}
	
	@AfterClass
	public void teardown()
	{
		//Browserfactory.quitbrowser(driver);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end",true);
		if(ITestResult.FAILURE==result.getStatus())
		{
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			
		}
		else if(ITestResult.SUCCESS==result.getStatus())
		{
			logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			
		}
		report.flush();
		Reporter.log("Test completed>>reports generated", true);
		
	}
	
	
	
	
	
}
