package com.appium.maas.pageobjects;

public class SecureMailInboxPage extends MailItemPage{
	
	public SecureMailInboxPage(){
		super();
	}
	
	public SecureMailISentItemPage selectSentItemsFolder(){
		actions.clickByXpath("EmailInbox_DropDown");
		actions.clickByName("EmailInboxDropdown_SentItems");
		return new SecureMailISentItemPage();
	}
	
	public SecureMailMultiSelectPage clickonMultiselctButton(){
		
		actions.clickByName("EmailMultiselctButton");
		return new SecureMailMultiSelectPage();
		
	}
	
public boolean isMailPresent(String key){
		
	
		return actions.isPresentByName(key);
		
		

	}

}
