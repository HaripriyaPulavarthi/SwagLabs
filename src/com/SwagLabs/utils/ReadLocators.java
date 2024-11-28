package com.SwagLabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadLocators {
	private Properties pro;
	public ReadLocators(String filename) throws IOException {
		String filepath=".//locators//"+filename+".properties";
		FileInputStream instream=new FileInputStream(filepath);
		 pro=new Properties();
		pro.load(instream);
	}
	public String getLocators(String locatorname) {
		return pro.getProperty(locatorname);
	}
	public static void main(String[] args) throws IOException {
		ReadLocators locators= new ReadLocators("loginpage");
		String locatorvalue=locators.getLocators("usernameL");
		System.out.println(locatorvalue);
		
	}
}
