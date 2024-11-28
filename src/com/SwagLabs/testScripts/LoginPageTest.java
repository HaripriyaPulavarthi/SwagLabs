package com.SwagLabs.testScripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SwagLabs.pages.LoginPage;
import com.SwagLabs.utils.Browser;
import com.SwagLabs.utils.DataConfigConstants;
import com.SwagLabs.utils.ReadData;

public class LoginPageTest extends Browser {
	@BeforeMethod
	public void setup() {
		openBrowser("chrome");
		OpenUrl();
	}
	@AfterMethod
	
	public void teardown() {
		CloseUrl();
	}
	@Test
	public void verifyLoginFuncctionalityWithUsernameBlank() throws IOException {
		LoginPage login=new LoginPage(driver,"loginpage") ;
		login.clickOnLoginBtn();
		String actual=login.getErrormsg();
		System.out.println(actual);
		Assert.assertEquals(actual, DataConfigConstants.USERNAME_BLANK);
			
		}
	@Test
	public void verifyLoginWithBlankPassword() throws IOException
	{
		LoginPage login=new LoginPage(driver,"LoginPage");
		ReadData read=new ReadData("loginpage");
		String uname=read.getData(1, 0);
		login.setUsername(uname);
		login.clickOnLoginBtn();
		String actual=login.getErrormsg();
		System.out.println(actual);
		Assert.assertEquals(actual, DataConfigConstants.PASSWORD_BLANK);
	}
	@Test
	public void verifyLoginWithInvalidUserNameAndPassword() throws IOException
	{
		LoginPage login=new LoginPage(driver,"LoginPage");
		ReadData read=new ReadData("loginPage");
		List<String> data= read.getData(5);
		login.setUsername(data.get(0));
		login.setPassword(data.get(1));
		login.clickOnLoginBtn();
		String actual=login.getErrormsg();
		System.out.println(actual);
		Assert.assertEquals(actual, DataConfigConstants.USERNAMEPASSWORD_BLANK);
		
	}
	}


