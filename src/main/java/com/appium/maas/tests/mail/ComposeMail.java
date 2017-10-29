package com.appium.maas.tests.mail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.maas.pageobjects.SecureMailISentItemPage;
import com.appium.maas.pageobjects.SecureMailInboxPage;

public class ComposeMail extends BaseLoginTest {
	@Test
	public void verifySendMail() {
		SecureMailInboxPage inboxpage = new SecureMailInboxPage();
		//SecureMailISentItemPage sentItemPage = inboxpage.clickComposeButton().sendMail().selectSentItemsFolder();
		//Assert.assertTrue(sentItemPage.isMailPresent("SubjectOfMail"), "Mail sent is not listed under sent items");
		//sentItemPage.selectInboxFolder();
		inboxpage.clickComposeButton().sendMail();
		Assert.assertTrue(inboxpage.isMailPresent("SubjectOfMail"), "Mail sent(to itself) is not listed under inbox");
		
	}

}
