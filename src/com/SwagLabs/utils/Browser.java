package com.SwagLabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	protected static WebDriver driver;
	public static void openBrowser(String browsername) {
		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else
			driver=new EdgeDriver();
	}
	public static void OpenUrl() {
		driver.get("https://www.saucedemo.com/");
	}
	public static void OpenUrl(String URL) {
		driver.get(URL);
	}
	public static void CloseUrl() {
		driver.close();
	}

}
