package com.qa.hub.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hub.base.BasePage;
import com.qa.hub.pages.HomePage;
import com.qa.hub.pages.LoginPage;
import com.qa.hub.util.Constants;

public class HomePageTest {
	
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SoftAssert softAssert;
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_properties();
		driver=basePage.init_driver(prop);
		loginPage =new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		softAssert =new SoftAssert();
	}
	
	@Test(priority=1)
	public void verifyHomePageHeaderValueTest() {
	
		Assert.assertTrue(homePage.verifyHomePageHeader());
	    String headervalue=homePage.getHomePageHeader();
	    System.out.println(headervalue);
	    Assert.assertEquals(headervalue,Constants.HOME_PAGE_HEADER);
	}
	
//	@Test(priority=2)
//	public void verifyLoggedInUserTest() {
//	
//		softAssert.assertTrue(homePage.verifyLoggedAccountName());
//	    String accountName=homePage.getLoggedAccountName();
//	    System.out.println(accountName);
//	    Assert.assertEquals(accountName,prop.getProperty("accountname"));
//	    System.out.println("end of the test...............");
//	    softAssert.assertAll();
//	}
//	
	@Test(priority=2)
	public void verifyHomePageAppLogo() {
	
		Assert.assertTrue(homePage.verifyApplicationLogo());
	   
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest() {
	
		String title=homePage.getHomePageTitle();
	    System.out.println(title);
	    Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
	
	
	
	
	

	@AfterTest
	public void quitBrowswer() {
		driver.quit();
	}


}
