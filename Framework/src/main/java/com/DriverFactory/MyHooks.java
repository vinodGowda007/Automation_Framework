package com.DriverFactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.ConfigFileReader;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks extends DriverLoadFactory {

	static ExtentReports extent;
	
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) throws IOException {
		System.out.println("I am in Before scenario");
		launchBrowser();
		driver.navigate().to(ConfigFileReader.readDataFromPropertyFile("url"));

		// Scenario methods
		System.out.println("Scenario Name : " + scenario.getName());
		System.out.println("Scenario ID " + scenario.getId());
		System.out.println("URI" + scenario.getUri());
		System.out.println("Lines " + scenario.getLine());
		System.out.println("Tags " + scenario.getSourceTagNames());
		System.out.println("Status " + scenario.getStatus());
	}

//	@After(order = 1)
//	public static void afterScenario(Scenario scenario) throws IOException {
//		boolean failed = scenario.isFailed();
//		System.out.println("is Failed ?" + failed);
//		try {
////			ExtentReports extent = new ExtentReports();
////			String path = System.getProperty("user.dir")+"/Report/Report/Index.html";
////			System.out.println(path);
////			ExtentSparkReporter spark = new ExtentSparkReporter(path);
////			spark.loadXMLConfig(new File("Extent-config.xml"));
////			extent.attachReporter(spark);
//			//ExtentTest test = extent.createTest("Tesing");
//
////		String screenshot = "";
////			if (failed) {
////				test.fail("Fail", MediaEntityBuilder.createScreenCaptureFromBase64String(
////						((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
////
////			}
//		} catch (Exception e) {
//			System.out.println("noooooooooooooooooooooooooooo");
//		}
//	}
//	
//	ExtentReports extent;

	@BeforeSuite
	public void setUp() throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/Administrator/eclipse-workspace/Framework/Report/Report/index.html");
		spark.loadXMLConfig(new File("C:\\Users\\Administrator\\eclipse-workspace\\Framework\\Extent-config.xml"));
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void tearDown() throws IOException
	{
		extent.flush();
		//Desktop.getDesktop().browse(new File("C:/Users/Administrator/eclipse-workspace/Framework/Report/Report/index.html").toURI());
	}
	
	
	
	
	@Test
	public void attachScreenshot(Scenario scenario) {
		
		ExtentTest test = extent.createTest("First Test");
		launchBrowser();
		driver.navigate().to(ConfigFileReader.readDataFromPropertyFile("url"));
		test.pass("Browser Opened");
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		test.pass("Value Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());		
	}
	
	public String getScreenshotAsBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
	
	
	
	
	
	

}
