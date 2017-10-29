package com.appium.maas.pageobjects;

public class SecureMailISentItemPage extends MailItemPage {
	
	public SecureMailISentItemPage(){
		super();
	}
	
	
	public SecureMailInboxPage selectInboxFolder(){
		actions.clickByXpath("SentItem_DropDown");
		actions.clickByName("SentItemsDropDown_Inbox");
		return new SecureMailInboxPage();
	}
	
	public boolean isMailPresent(String SubjectOfMail){
		
		if(actions.isPresentByName(SubjectOfMail))
			return true;
		else 
			return false;
	}

}
