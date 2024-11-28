package com.SwagLabs.utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartFunctions {
	protected ReadLocators read;
	protected WebDriver driver;
	public SmartFunctions(WebDriver driver,String filename) throws IOException {
		 read=new ReadLocators(filename);
		 this.driver=driver;
	}
	protected WebElement getElement(String locatorname) {
		String locatorValue=read.getLocators(locatorname);
		By locator=By.xpath(locatorValue);
		return driver.findElement(locator);
	}
	protected List<WebElement> getElements(String locatorname){
		String locatorvalue=read.getLocators(locatorname);
		By locator=By.xpath(locatorvalue);
		return driver.findElements(locator);
		
	}
	protected void setText(String locatorname,String data) {
	getElement(locatorname).sendKeys(data);
	}
	protected void click(String locatorname) {
		getElement(locatorname).click();
	}
	protected String getText(String locatorname) {
		return getElement(locatorname).getText();
	}
	protected boolean isElementDisplayed(String locatorname) {
		try {
		return getElement(locatorname).isDisplayed();}
		
		catch(Exception e) {
			return false;
		}
	}

}
