package com.appium.maas.tests.mail;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.appium.maas.pageobjects.LoginPage;
import com.appium.maas.pageobjects.SecureMailInboxPage;
import com.appium.maas.pageobjects.SecureMailLoginWelcomePage;

public abstract class BaseLoginTest {
	
	@BeforeSuite(alwaysRun=true)
	public void beforeClass(){
	    LoginPage lp = new LoginPage();
		SecureMailLoginWelcomePage loginWebPage = lp.clickOnSigninButton();
		Assert.assertTrue(loginWebPage.isWelcomeLogoPresent(), "Welcome logo is not present on the welcome screen");
		SecureMailInboxPage inboxPage = loginWebPage.clickSkipButton();
	    Assert.assertTrue(inboxPage.isComposeButtonPresent(), "Compose button missing from Screen");
		Assert.assertTrue(inboxPage.isNavigationButtonPresent(), "Navigation menu button missing from Screen");
	}	
}
