package com.qa.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hub.base.BasePage;
import com.qa.hub.util.ElementUtil;

public class Profilepage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	//page locators
	By emailID = By.id("username");
	
	//page class constructor
	public Profilepage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}

}
