package com.qa.hub.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;
	
	public static String TESTDATA_SHEETPATH="C://Users//stalagad.IGATEGEGDC//eclipse-workspace//PomProject//src//main//java//com//qa//hub//testdata//HubSpotTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		try {
			FileInputStream ip= new FileInputStream(TESTDATA_SHEETPATH);
			book =WorkbookFactory.create(ip);//Creates memory in Java
		   sheet=book.getSheet(sheetName);
		   Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
		   for(int i =0;i<sheet.getLastRowNum();i++) {
			   for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				   data[i][k]=  sheet.getRow(i+1).getCell(k).toString();
			   }
		   }
		   
		   return data;
		   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
