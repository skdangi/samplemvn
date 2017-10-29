package com.appium.maas.pageobjects;
import com.appium.maas.common.Initialization;

public class LoginPage extends Initialization{
	
	
	//AppiumActions actions= new AppiumActions();
	public SecureMailLoginWelcomePage clickOnSigninButton(){
		actions.clickByName("Email");
		actions.clickByXpath("SecureMailPassword");
		actions.typeByXpath("SecureMailPassword" , "Password");
		actions.clickByName("SucureMailSignInButton");
		return new SecureMailLoginWelcomePage();
}
}
