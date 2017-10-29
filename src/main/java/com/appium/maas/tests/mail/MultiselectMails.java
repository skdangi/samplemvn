package com.appium.maas.tests.mail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.maas.pageobjects.SecureMailInboxPage;
import com.appium.maas.pageobjects.SecureMailMultiSelectPage;


public class MultiselectMails extends BaseLoginTest{
	//SecureMailInboxPage inboxPage = new SecureMailInboxPage();
	
	@Test
	public void multiselectCancel(){
		
		SecureMailInboxPage inboxPage = new SecureMailInboxPage();
		
		SecureMailMultiSelectPage multiselectpage = inboxPage.clickonMultiselctButton();
		Assert.assertFalse(inboxPage.isComposeButtonPresent(), "Compose button is present on multiselect screen");
		multiselectpage.clickCancel();
		Assert.assertTrue(inboxPage.isComposeButtonPresent(), "Compose button is not present on  inbox screen");
		
}
	//@Test
	public void multiselectDelete(){
		SecureMailInboxPage inboxPage = new SecureMailInboxPage();
		SecureMailMultiSelectPage multiselectpage = inboxPage.clickonMultiselctButton();
		multiselectpage.selectMails("SubjectOfMail");
	    inboxPage=multiselectpage.clickDelete();
		Assert.assertTrue(inboxPage.isComposeButtonPresent(),"Compose button is not present on inboc page");
		Assert.assertFalse(inboxPage.isMailPresent("SubjectOfMail"),"Mail didn't get delete");
		
		
	}
	
	

}
