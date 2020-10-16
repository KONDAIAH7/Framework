package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Browserfactory
{

	@Test
	public static WebDriver startapplication(WebDriver driver,String browsername,String appurl)
	{
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	public static void quitbrowser(WebDriver driver)
	{
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
