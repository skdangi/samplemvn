package com.appium.maas.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.ios.IOSDriver;

public class AppiumActions {
	
	static IOSDriver  driver = Initialization.getDriver();
	
	public void clickByName(String key){
		
		System.out.println(Initialization.getIdentifier(key));
		System.out.println(By.name(Initialization.getIdentifier(key)));
		System.out.println(driver);
		System.out.println(driver.findElement(By.name(Initialization.getIdentifier(key))));
	driver.findElement(By.name(Initialization.getIdentifier(key))).click();;
	}
	
	public void clickByXpath(String key){
		
		driver.findElement(By.xpath(Initialization.getIdentifier(key))).click();;
		}
	
public  void typeByName(String key, String text){
		
	driver.findElement(By.name(Initialization.getIdentifier(key))).sendKeys(Initialization.getTestData(text));
	
		}

public void typeByXpath(String key, String text){
	
	driver.findElement(By.xpath(Initialization.getIdentifier(key))).sendKeys(Initialization.getTestData(text));
	}

public boolean isPresentByName(String key){
	
	try {
		driver.findElement(By.name(Initialization.getIdentifier(key)));
		return true;
	}
	catch(NoSuchElementException e){
		return false;
	}
	
}

public boolean isPresentByXpath(String key){
	
	try {
		driver.findElement(By.xpath(Initialization.getIdentifier(key)));
		return true;
	}
	catch(Exception e){
		return false;
	}
	
}


}
