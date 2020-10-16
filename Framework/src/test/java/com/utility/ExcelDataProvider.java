package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{

	XSSFWorkbook wb;
	public  ExcelDataProvider()
	{
		File src= new File("./Testdata/Test.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			} 
		catch (Exception e) 
		{
			System.out.println("unable to read excel file:"+e.getMessage());
		}
			
	}
	
	public String getStringdata(String sheetnamme,int row,int column)
	{
		return wb.getSheet(sheetnamme).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericdata(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
}
