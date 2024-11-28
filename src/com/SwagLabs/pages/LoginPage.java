package com.SwagLabs.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.SwagLabs.utils.SmartFunctions;

public class LoginPage extends SmartFunctions {

	public LoginPage(WebDriver driver, String filename) throws IOException {
		super(driver, filename);
		// TODO Auto-generated constructor stub
	}
public void setUsername(String uname) {
	setText("usernameL", uname);
}
public void setPassword(String pass) {
	setText("passwordL", pass);
	
}
public void clickOnLoginBtn() {
	click("loginL");
}

public String getErrormsg( ) {
	return getText("ErrormsgL");
	
}
}