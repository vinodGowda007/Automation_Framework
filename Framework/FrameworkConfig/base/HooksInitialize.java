package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DriverFactory.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksInitialize {

	public String browserType;
	public static ExtentReports extent;
	public ExtentTest test;
	String headlessMode;
	Base base;

	public String parentDirectory = System.getProperty("user.dir");

	public String ReportPath = parentDirectory + "/Report/" + "Reports_" + getDateOrTime("date")
			+ getDateOrTime("time");

	public HooksInitialize() {
		browserType = ConfigFileReader.readDataFromPropertyFile("browser");
		headlessMode = ConfigFileReader.readDataFromPropertyFile("headlessMode");
	}

	public void InitializeBrowserSettings() {
		OpenBrowser(browserType, headlessMode);
	}

	public static String getDateOrTime(String requiredFormat) {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH_mm:ss");
		dateFormat.setTimeZone(TimeZone.getDefault());
		timeFormat.setTimeZone(TimeZone.getDefault());
		String DateorTime = null;

		if (requiredFormat.toLowerCase().equals("date")) {
			DateorTime = dateFormat.format(date);
		}
		if (requiredFormat.toLowerCase().equals("time")) {
			DateorTime = timeFormat.format(date);
		}
		return DateorTime;
	}

	public void OpenBrowser(String browserType, String headlessMode) {

		switch (browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			if (headlessMode.equals("Yes")) {
				options.addArguments("--headless");
				options.addArguments("window-size=1366,667");
			}
			base.driver = new ChromeDriver(options);
			base.driver.manage().deleteAllCookies();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver();
			base.driver = new FirefoxDriver();
			base.driver.manage().deleteAllCookies();
			break;

		case "ie":
			throw new RuntimeException(
					" Dear User, Working on IE / Edge browser setup... , Use only Chrome or Firefox browser to Automate ");

		default:
			throw new RuntimeException("Could not find the matching browser, Please check your browser config file");
		}

	}

	public void InititlizeExtentReport() {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(parentDirectory);
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}

}
