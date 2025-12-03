package utility;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;




public class ExcelUtility {
	
	static FileInputStream f; //class helps to read excel file
 	static XSSFWorkbook w; //class to open the excel file
 	static XSSFSheet sh;  //class to read a particular sheet
  
 	public static String readStringData(int row, int col, String sheet) throws IOException { // to readString data,there will be a chance of io exception
 				
 		f = new FileInputStream(Constants.TESTDATA); // this is an object
 		
 		w = new XSSFWorkbook(f); 
 		sh = w.getSheet(sheet); 
 		XSSFRow r = sh.getRow(row); 
 		XSSFCell c = r.getCell(col); 
 		return c.getStringCellValue(); 
  
 	} 
  
 	public static String readIntegerData(int row, int col, String sheet) throws IOException { // more benefitioury when we return string than a int
 		f = new FileInputStream(Constants.TESTDATA); 
 		w = new XSSFWorkbook(f); 
 		sh = w.getSheet(sheet); 
 		XSSFRow r = sh.getRow(row); 
 		XSSFCell c = r.getCell(col); 
 		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting 
 		return String.valueOf(val);   //convert int to string using valueOf() method 
 		//return val; 
 	 
 	} 
}