package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Loginapp
{
	WebDriver driver;
	// new comment fron kk
	@Test
	public void loginpage(WebDriver ldriver)
	{
		this.driver= ldriver;
		
	}
	@FindBy(id="inputEmail3") WebElement uname;
	@FindBy(id="inputPassword3") WebElement pwd;
	@FindBy(css=".btn-primary") WebElement lgnbtn;
	
	
	
	
	public void logintobcqam(String username,String password)
	{
		try 
		{
			
			Thread.sleep(3000);
		} 
		catch (InterruptedException e)
		{
		
		}
		
		uname.sendKeys(username);
		pwd.sendKeys(password);
		lgnbtn.click();
	}
	
	

}
