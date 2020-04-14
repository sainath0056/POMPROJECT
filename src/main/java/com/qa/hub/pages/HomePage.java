package com.qa.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hub.util.ElementUtil;

public class HomePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header=By.cssSelector("h1.private-page__title");
	By accountname=By.cssSelector("span.account-name");
	By logo=By.cssSelector("li>a#nav-primary-home");
	
	By contactsparentTab=By.id("nav-primary-contacts-branch");
	By contactsChildTab=By.id("nav-secondary-contacts");
	
	public  HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		elementUtil.waitForElementPresent(header);
	}
	
//PageActions
	public String getHomePageTitle() {
		return elementUtil.doGetTitle();
	}

	public boolean verifyHomePageHeader() {
		
	
		return elementUtil.doIsDisplayed(header);
	}

	public String getHomePageHeader() {
		return elementUtil.doGetText(header);
	}

	public boolean verifyLoggedAccountName() {
		
		return elementUtil.doIsDisplayed(accountname);
	}
	
	public String getLoggedAccountName() {
		return elementUtil.doGetText(accountname);
	}
	
	public boolean verifyApplicationLogo() {
		return elementUtil.doIsDisplayed(logo);
	}
	
	public ContactsPage goToContactsPage() {
		
		elementUtil.waitForElementPresent(contactsparentTab);
		elementUtil.doClick(contactsparentTab);
		elementUtil.waitForElementPresent(contactsChildTab);
		elementUtil.doClick(contactsChildTab);
		
		return new ContactsPage(driver);
	}
	
	
}
