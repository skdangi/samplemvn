package com.appium.maas.pageobjects;

import com.appium.maas.common.Initialization;

public class ComposeMailPage extends Initialization {
	
		
		public SecureMailInboxPage sendMail(){
			//actions.clickByxpath("ComposeMail_ToField");
			actions.typeByXpath("ComposeMail_ToField", "SendMailToField");
			actions.clickByName("ComposeMail_return");
			actions.clickByName("ComposeMail_Subject");
			actions.typeByName("ComposeMail_Subject", "SubjectOfMail");
			actions.clickByName("ComposeMail_SendMail");
			return new SecureMailInboxPage();
		}
	}

	
	


