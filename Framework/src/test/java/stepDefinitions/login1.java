package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.GmailPage;


public class login1  {
	
	private GmailPage gmailpage;

//	@Given("User launch browser and navigate to google url")
//	public void user_launch_browser_and_navigate_to_google_url() {
//		gmailpage.NavigateToTestEnvironment();
//	}

	@Then("User Click on {string} link")
	public void user_click_on_link(String linkName) {
		gmailpage.clickOntheLinks(linkName);
	}

}
