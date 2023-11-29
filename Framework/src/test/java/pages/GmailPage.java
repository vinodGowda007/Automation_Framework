package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DriverFactory.Base;

public class GmailPage {

	WebDriver driver;

	public GmailPage(Base base) {
		this.driver = base.getDriver();
	}

//	private By lnk_Gmail(String linkName)
//	{
//		String locatorLink = "//a[text()='" + linkName + "']";
//		return By.xpath(locatorLink);
//		
//	}

	private By lnk_Gmail(String linkName) {

		return By.xpath(String.format("//a[text()='%s']", linkName));
	}

	public void clickOntheLinks(String linkName) {
		System.out.println("Link Text = " + linkName);
//		WaitAndclick(lnk_Gmail(linkName));
		System.out.println("Clicked on Gmail link");
	}

}
