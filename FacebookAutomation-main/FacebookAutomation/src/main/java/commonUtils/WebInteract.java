package commonUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WebInteract {

	private static WebDriver webDriver;
	private final static int WAITING_TIME = Integer.parseInt(System.getProperty("implicit.wait"));
	
	
	public static void setWebDriver(WebDriver _webDriver) {
		webDriver = _webDriver;
	}

	
	public static void waitForPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(webDriver, 30);
			wait.until(expectation);
		} catch (Throwable error) {

		}
	}
	
	
	public static void click(By by) {
		waitForElement(by);
		javaClick(by);
	}
	
	public static void javaClick(By by) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", webDriver.findElement(by));
	}
	
	public static void type(By by, String text) {
		waitForElement(by);
		do {
			try {
				webDriver.findElement(by).clear();
				webDriver.findElement(by).sendKeys(text);
				break;
			} catch (StaleElementReferenceException e) {

			}
		} while (true);
	}
	
	
	public static void waitForElement(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(WAITING_TIME, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class).ignoring(TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}
	
	public static String getText(By by) {
		return webDriver.findElement(by).getText();
	}
	
	public static boolean isDisplayed(By by) {
		try {
			waitForVisibleElement(by);
			boolean displayed = webDriver.findElement(by).isDisplayed();
			return displayed;
		} catch (NoSuchElementException | TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void waitForVisibleElement(final By by) {
		WebDriverWait wait = new WebDriverWait(webDriver, WAITING_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void pause(int waitTime) {
		try {
			Thread.sleep(waitTime);
		}catch(InterruptedException exception) {
			
		}
	}
	
	public static void refershPage() {
		webDriver.navigate().refresh();
		waitForPageLoad();
	}
	
}
