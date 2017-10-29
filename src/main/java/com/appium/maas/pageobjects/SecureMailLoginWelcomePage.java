package com.appium.maas.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.appium.maas.common.Initialization;
import com.google.common.base.Function;

public class SecureMailLoginWelcomePage extends Initialization {

	public SecureMailLoginWelcomePage() {
			waitUntil(By.name(Initialization.getIdentifier("SKIP")));
	}

	public SecureMailInboxPage clickSkipButton() {
		actions.clickByName("SKIP");
		return new SecureMailInboxPage();
	}
	
	public boolean isWelcomeLogoPresent() {
		try{
		actions.isPresentByName("EmailWelcomeScreen_Welcome_Name");
		return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	
}
