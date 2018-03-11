package com.automationpractice.excelreading;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	public String path;
	public XSSFWorkbook workbook;//XSSFSheet is class created by apache poi 
	public FileInputStream fis;// fileinputstream is a class created in java
	/*public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;*/
	
	
    public Excel_Reader(String path){//constructors are used to initialise values for the instance variables.
    	this.path=path; 
    	try{
			fis=new FileInputStream(path);//creating an object for fileinputstream class.which takes argument as a path,so that fis can read that given path.
			workbook=new XSSFWorkbook(fis);//creating an object for XSSFWorkbook class.which takes argument as fis.this will take the path of excel sheet.
    	}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    public String[][] getDataFromSheet(String sheetname, String excelname){
		String datasets[][]=null;
		try{
		//get sheet from excel workbook
		XSSFSheet sheet=workbook.getSheet(sheetname);
		//count num of active rows
		int totalrow=sheet.getLastRowNum()+1;//total records in the sheet.actually it takes from 0 so will add +1 to get atotal records.
		//count num of active columns
		int totalcolumn=sheet.getRow(0).getLastCellNum();
		//create array of object for rows and columns
		datasets=new String[totalrow-1][totalcolumn];
		//Run for loop and store that data in the 2D array
		//This for loop will run on rows
		for(int i=1;i<totalrow;i++){
		        XSSFRow rows=sheet.getRow(i);
			//This for loop will run on columns
			for(int j=0;j<totalcolumn;j++){
				//getcell method will get the cell
				XSSFCell cell=rows.getCell(j);
				//if cell of type string this if condition will work.
				if(cell.getCellType()==cell.CELL_TYPE_STRING)
					datasets[i-1][j]=cell.getStringCellValue();//if that type is string then we need to get that data from the cell
				//if cell type is numeric then this if condition will work.
				else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
					datasets[i-1][j]=String.valueOf(cell.getNumericCellValue());
				//if cell type is boolean then this if condition will work.
				}else 
					datasets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
			}
		
				
		}
		
		//return datasets;
    	
    }catch(Exception e){
    	e.printStackTrace();
    }
		return datasets;
		

}
}
