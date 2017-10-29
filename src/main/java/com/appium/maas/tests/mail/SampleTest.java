package com.appium.maas.tests.mail;

import com.appium.maas.common.AppiumActions;
import com.appium.maas.pageobjects.ComposeMailPage;
import com.appium.maas.pageobjects.LoginPage;
import com.appium.maas.pageobjects.SecureMailInboxPage;
import com.appium.maas.pageobjects.SecureMailLoginWelcomePage;

public class SampleTest {
	
	public static void main(String arge[]){
		AppiumActions actions = new AppiumActions();
		actions.clickByXpath("EmailInbox_DropDown");
	}

}
