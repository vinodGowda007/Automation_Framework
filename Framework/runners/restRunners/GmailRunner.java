package restRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features",
		glue = {"com.DriverFactory","stepDefinitions"},
		monochrome = true,
//		plugin ="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		plugin= {"pretty","html:target/Cucumber/cucumber-reports.html",
						"html:target/HTMLReports/htmlreports.html",
						"json:target/JSONReports/reports.json",
						"junit:target/JunitReports/junitreports.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class GmailRunner extends AbstractTestNGCucumberTests {
	
}
