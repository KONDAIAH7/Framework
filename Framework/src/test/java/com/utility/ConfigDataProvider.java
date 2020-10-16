package com.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;

public class ConfigDataProvider 
{

	Properties pro;
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro=new Properties();
		
			pro.load(fis);
		} 
		catch (Exception e) 
		{
		System.out.println("not able to load file:"+e.getMessage());
		}
		
	}
	public String getDatafromconfig(String keytosearch)
	{
		return pro.getProperty(keytosearch);
	}
	
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURL");
	}
	
	
	
}
