package com.qa.hub.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hub.base.BasePage;
import com.qa.hub.listeners.ExtentReportListener;
import com.qa.hub.pages.HomePage;
import com.qa.hub.pages.LoginPage;
import com.qa.hub.util.Constants;
//@Listeners(ExtentReportListener.class)
public class LoginPageTest {
	
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_properties();
		driver=basePage.init_driver(prop);
		loginPage =new LoginPage(driver);
	}
	
	@Test(priority=1,enabled=true)
	public void verifyLoginPageTitleTest() {
	Reporter.log("Test Started....>"+"Verify loginpage Title Test"+"\n");
	String title=loginPage.getLoginPageTitle();
	System.out.println("login page title:"+ title);
	Reporter.log("login page title is: " + title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	Reporter.log("Test ended--> "+ "verifyLoginPageTitleTest" );
		
	}
	@Test(priority=2,enabled=true)
	public void verifySignUpLinkTest() {
	
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
//	@Test(priority=3,enabled=false)
//	public void verifyLoginTest() {
//	
//	homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
//	Assert.assertTrue(homePage.verifyLoggedAccountName());
//	Assert.assertEquals(homePage.getLoggedAccountName(),prop.getProperty("accountname"));
//	}
//	
//	
	@AfterTest
	public void quitBrowswer() {
		driver.quit();
	}

}
