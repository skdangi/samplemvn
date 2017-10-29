package com.appium.maas.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Initialization {
	// private Map<String,String>;
	private static Properties identifiers;
	private static Properties testData;
	private static IOSDriver driver;
	protected static AppiumActions actions;
	static {

		try {

			// Driver Initialization

			DesiredCapabilities capabilities = new DesiredCapabilities();
			AppiumDriverLocalService service;
			int port = 4723;
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().withIPAddress("0.0.0.0").usingPort(port));
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone 6");
			capabilities.setCapability("platformVersion", "11.0");

			// note if platform version is 10 or above must to set
			// capabilities.setCapability("AUTOMATION_NAME","XCUITest")

			capabilities.setCapability("bundleId", "com.fiberlink.maas360.enterpriseappstore");
			// com.fiberlink.maas360.enterpriseappstore
			capabilities.setCapability("udid", "c51a0190f40c5fc58e6bd3e052e9a6985f53cb03");
			capabilities.setCapability("deviceOrientation", "portrait");
			capabilities.setCapability("appiumVersion", "1.7.1");
			// capabilities.setCapability("xcodeConfigfile",
			// "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");
			capabilities.setCapability("AUTOMATION_NAME", "XCUITest");
			capabilities.setCapability("newCommandTimeout", "90");
			driver = new IOSDriver(service, capabilities);
			

			actions = new AppiumActions();

			// Identifiers and test data initialization

			// File file = new
			// File(System.getProperty("user.dir")+"/Data/identifiers.properties");
			// System.out.println(file.getAbsolutePath());
			FileInputStream fileInput = new FileInputStream(
					System.getProperty("user.dir") + "/Data/identifiers.properties");
			identifiers = new Properties();
			identifiers.load(fileInput);
			// System.out.println(props.getProperty("Email"));
			// fileInput.close();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/Data/testData.properties");
			testData = new Properties();
			testData.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static IOSDriver getDriver() {
		return driver;
	}

	public static String getIdentifier(String key) {
		return identifiers.getProperty(key);
	}

	public static String getTestData(String key) {
		return testData.getProperty(key);
	}

	protected static void waitUntil(final By by) {
		Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		Function func = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		};
		wait.until(func);
	}
}
