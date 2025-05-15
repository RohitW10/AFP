package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webElement;
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public Boolean waitForInvisibilityOfElement(WebElement element, long durationInSeconds)
	{
		Boolean webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		if (webElement != null) {
	        webElement.click();
	    } else {
	        throw new RuntimeException("Element not clickable: " + element);
	    }	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped, long durationInSeconds)
	{
		WebElement webElement = waitForElement(element, durationInSeconds);
		if (webElement != null) {
	        webElement.click();
	    } else {
	        throw new RuntimeException("Element not clickable: " + element);
	    }
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public void mouseHover(WebElement element, long durationInSeconds)
	{
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).build().perform();
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
		
	} 
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getValueFromAttribute(WebElement element)
	{
		return element.getDomAttribute("value");
	}
	
	public void selectElementUsingValue(WebElement element, String value, long durationInSeconds)
	{
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select selectOption = new Select(webElement);
		selectOption.selectByValue(value);
	}

	public void scrollIntoView(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block : 'center'});" , element);
	}
	
	public void clickWithJS(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
}
