package com.DriverFactory;

import org.openqa.selenium.WebDriver;

public class Base {
	
	
	public WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
