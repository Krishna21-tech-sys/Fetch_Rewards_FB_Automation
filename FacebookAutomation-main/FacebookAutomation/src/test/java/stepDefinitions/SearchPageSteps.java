package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonUtils.WebInteract;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageActions.LoginPage;
import pageActions.PageSearch;
import runner.SharedDriver;

public class SearchPageSteps {
	private LoginPage loginPage;
	private PageSearch pageSearch;
	
	public SearchPageSteps(SharedDriver webDriver) {
		pageSearch = new PageSearch(webDriver);
		loginPage = new LoginPage(webDriver);
	}
	
	@Given("I have successfully logged in, into the application")
	public void i_have_successfully_logged_in_into_the_application() {
		loginPage.loginToApplication();
	}

	@When("I search for the {string} page")
	public void i_search_for_the_page(String searchString) {
		pageSearch.search(searchString);
	}

	@Then("Search result should retun {string} page")
	public void search_result_shuould_retun_page(String pageName) {
		Assert.assertTrue(pageName + " page is not retunned ", pageSearch.verifyPageReturned(pageName));
	}

	@When("I open the {string} page")
	public void i_open_the_page(String pageName) {
		pageSearch.openPage(pageName);
	}

	@When("I Click on the like button")
	public void i_Click_on_the_like_button_for_page() {
		pageSearch.clickOnLikeButton();
	}

	@Then("Page with name {string} shpould be liked")
	public void page_with_name_shpould_be_liked(String pageName) {
		Assert.assertTrue(pageName + " is not liked", pageSearch.verifyPageLiked());
		pageSearch.unlikeThePage();
	}
}
