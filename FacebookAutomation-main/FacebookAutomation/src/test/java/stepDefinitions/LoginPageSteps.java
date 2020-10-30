package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageActions.LoginPage;
import pageActions.PageSearch;
import runner.SharedDriver;

public class LoginPageSteps {
	private LoginPage loginPage;
	private PageSearch pageSearch;

	public LoginPageSteps(SharedDriver webDriver) {
		loginPage = new LoginPage(webDriver);
		pageSearch = new PageSearch(webDriver);
	}

	@Given("I have launched the application")
	public void i_have_lanched_the_application() {
		loginPage.openLoginPage();
	}

	@When("I enter {string} as user name and {string} as password")
	public void i_enter_as_user_name_and_as_password(String userName, String password) {
		loginPage.login(userName, password);
	}

	@When("I click on the Log In button")
	public void i_click_on_the_Log_In_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("I should be successfully logged into the application")
	public void i_should_be_successfully_logged_into_the_application() {
		String userName = System.getProperty("qa.username");
		System.out.println(">>>>>>>>>>>> "+ userName);
		Assert.assertTrue("User is not logged in", pageSearch.verifyUserNameDisplayed(userName));
	}
}
