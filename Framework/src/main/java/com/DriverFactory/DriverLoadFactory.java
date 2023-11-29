package com.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLoadFactory extends Base {

	static ConfigFileReader config = new ConfigFileReader();

	public WebDriver launchBrowser() {
		String browserName = ConfigFileReader.readDataFromPropertyFile("browserName");
		System.out.println("Launching " + browserName + " Browser");		
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); 
			options.addArguments("enable-automation"); 
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			break;
			
		case "ie": 
			throw new RuntimeException(" Dear User, Working on IE / Edge browser setup... , Use only Chrome or Firefox browser to Automate ");
			
		default:
			System.out.println("Could not find the matching word");
			break;
		}
		
		return driver;
	}

}
