package pageActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonUtils.WaitTimes;
import commonUtils.WebInteract;
import pageElements.LoginPageElements;

public class LoginPage {
	private WebDriver webDriver;
	private LoginPageElements loginPageElements;
	
	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		loginPageElements = new LoginPageElements();
	}

	public void login(String userName, String password){
		openLoginPage();
		WebInteract.type(By.id(loginPageElements.userName), userName);
		WebInteract.type(By.id(loginPageElements.password), password);
	}
	
	public void clickOnLoginButton() {
		WebInteract.click(By.xpath(loginPageElements.loginButton));
		WebInteract.waitForPageLoad();
	}

	public void openLoginPage() {
		webDriver.get("https://facebook.com");
		WebInteract.pause(WaitTimes.MAXIMUM_WAIT_TIME);
	}
	
	public void loginToApplication() {
		String userName = System.getProperty("qa.user");
		String password = System.getProperty("qa.password");
		openLoginPage();
		login(userName, password);
		clickOnLoginButton();
	}
}
