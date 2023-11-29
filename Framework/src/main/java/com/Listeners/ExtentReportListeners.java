package com.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListeners {
	
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	static WebDriver driver;
	
	public static ExtentReports setUp() {
		String reportLocation = "";
		report =  new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initialized...");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		System.out.println("System Info set in Extent Report");
		return extent;		
	}
	
	
	
	
	
	public static void testStepHandle(String testStatus, WebDriver driver, ExtentTest extentTest, Throwable throwable)
	{
		switch (testStatus) {
		case "FAIL":
			extentTest.fail(MarkupHelper.createLabel("Testcase is Failed : ", ExtentColor.RED));
			extentTest.info(throwable.getMessage());
			test.fail("Value Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
			break;
			
		case "PASS":
			extentTest.pass(MarkupHelper.createLabel("Testcase is Passed : ", ExtentColor.GREEN));

		default:
			break;
		}
	}
	
	public static String getScreenshotAsBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	

}
