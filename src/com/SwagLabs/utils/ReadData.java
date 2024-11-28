package com.SwagLabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	private XSSFSheet sheet;
	public ReadData(String FileName) throws IOException {
		String filepath=".//testData//"+FileName+".xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(instream);
		 sheet=workbook.getSheet("Sheet1");
	}
	public String getData(int rownum,int colnum) { 
		return sheet.getRow(rownum).getCell(colnum).getStringCellValue();
	}
	public List<String> getData(int rownum){
		List<String>rowData=new ArrayList<String>();
		int colNum=sheet.getRow(rownum).getLastCellNum();
		for(int i=0;i<colNum;i++) {
			String data=sheet.getRow(rownum).getCell(i).getStringCellValue();
			rowData.add(data);
		}
		return rowData;		
	}
	public String[][] getData(){
		int rowcount=sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		String tableData[][]=new String[rowcount][colnum];
		int k=0,l;
		for(int i=1;i<=rowcount;i++) {
			l=0;
			for(int j=0;j<colnum;j++) {
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				tableData[k][l]=data;
				l++;
			}
			k++;
		}
		return tableData;
	}
	public static void main(String[] args) throws IOException {
		ReadData data=new ReadData("loginpage");
		String value=data.getData(1, 0);
		System.out.println(value);
		List<String> rowData=new ArrayList<String>();
		rowData=data.getData(1);
		System.out.println(rowData);
		String tableData[][]=data.getData();

		for(int i=0;i<tableData.length;i++) {
			for(int j=0;j<tableData[i].length;j++) {
				System.out.print(tableData[i][j]  +   "");
			}
			System.out.println();
		}

		
	}

}
