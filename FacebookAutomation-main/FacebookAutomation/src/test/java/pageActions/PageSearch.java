package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonUtils.WaitTimes;
import commonUtils.WebInteract;
import pageElements.PageSearchElements;

public class PageSearch {
	private static WebDriver webDriver;
	private PageSearchElements pageSearchElements;

	public PageSearch(WebDriver webDriver) {
		this.webDriver = webDriver;
		pageSearchElements = new PageSearchElements();
	}

	public boolean verifyUserNameDisplayed(String userName) {
		return WebInteract.isDisplayed(By.xpath(String.format(pageSearchElements.lohggedInUserName, userName)));
	}

	public void search(String value) {
		WebInteract.refershPage();
		WebInteract.type(By.xpath(pageSearchElements.searchBox), value);
		WebInteract.pause(WaitTimes.MEDIUM_WAIT_TIME);
		WebInteract.click(By.xpath(pageSearchElements.searchButton));
		WebInteract.waitForPageLoad();
	}

	public boolean verifyPageReturned(String pageName) {
		return WebInteract.isDisplayed(By.xpath(String.format(pageSearchElements.pageLink, pageName)));
	}

	public void openPage(String pageName) {
		WebInteract.click(By.xpath(String.format(pageSearchElements.pageLink, pageName)));
		WebInteract.pause(WaitTimes.MEDIUM_WAIT_TIME);
		WebInteract.waitForPageLoad();
	}
	
	public void clickOnLikeButton() {
		WebInteract.click(By.xpath(pageSearchElements.likeButton));
		WebInteract.pause(WaitTimes.SMALL_WAIT_TIME);
	}
	
	public boolean verifyPageLiked() {
		return WebInteract.isDisplayed(By.xpath(pageSearchElements.likedButton));
	}
	
	public void unlikeThePage() {
		WebInteract.click(By.xpath(pageSearchElements.likedButton));
		WebInteract.click(By.xpath(pageSearchElements.unlikeThePage));
	}
}
