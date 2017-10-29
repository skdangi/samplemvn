package com.appium.maas.pageobjects;

import org.openqa.selenium.By;

import com.appium.maas.common.Initialization;

public class SecureMailMultiSelectPage extends Initialization{
	
	public SecureMailMultiSelectPage(){
		
		waitUntil(By.name(Initialization.getIdentifier("CancelButton")));
	}
	
	public SecureMailInboxPage clickCancel(){
		
		actions.clickByName("CancelButton");
		return new SecureMailInboxPage();
		
	}
	
	public void selectMails(String key) {
		actions.clickByName(key);
	}
	
/*	public boolean isPresentComposeButton(){
		
			if(actions.isPresentByName("ComposeButton"));
			return true;*/
		
	
	
	public SecureMailInboxPage clickDelete() {
		actions.clickByName("DeleteMail");
		return new SecureMailInboxPage();

	}

	}

	
	
	

