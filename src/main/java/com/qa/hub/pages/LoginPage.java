package com.qa.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hub.util.Constants;
import com.qa.hub.util.ElementUtil;

//import com.qa.hubspot.pages.HomePage;


public class LoginPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	//page locators
	By emailID = By.id("username");
	By password =By.id("password");
	By loginButton =By.id("loginBtn");
	By signUpLink =By.linkText("Sign up");
	//page class constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//pageActions
	
	public String getLoginPageTitle() {
		elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}
	
	public boolean isSignUpLinkExists() {
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String username,String pwd) {
		
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		
		return new HomePage(driver);
		
	}
	

}
