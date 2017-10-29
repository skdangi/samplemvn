package com.appium.maas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.appium.maas.common.Initialization;

public abstract class MailItemPage extends Initialization {

	public MailItemPage() {
		waitUntil(By.name(Initialization.getIdentifier("ComposeButton")));
	}

	public ComposeMailPage clickComposeButton() {
		actions.clickByName("ComposeButton");
		return new ComposeMailPage();
	}

	public boolean isComposeButtonPresent() {
			return actions.isPresentByName("ComposeButton");
	}

	public void clickMultiselectButton() {
		actions.clickByName("EmailMultiselctButton");
	

	}

	

	public boolean isNavigationButtonPresent() {
		try {
			actions.isPresentByName("ContainerNavigation");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
