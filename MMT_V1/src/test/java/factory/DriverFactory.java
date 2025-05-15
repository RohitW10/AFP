package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonUtils;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static WebDriver initializeBrowser(String browserName) {
		
		WebDriver driver;
		
		switch(browserName.toLowerCase()) {
		
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpns = new ChromeOptions();
			chromeOpns.addArguments("--incognito", "--disable-notifications", "--start-maximized");
			driver = new ChromeDriver(chromeOpns);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOpns = new EdgeOptions();
			edgeOpns.addArguments("--inprivate", "--disable-notifications", "start-maximized");
			driver = new EdgeDriver(edgeOpns);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpns = new FirefoxOptions();
			firefoxOpns.addArguments("--private", "--disable-notifications", "--start-maximized");
			driver = new FirefoxDriver(firefoxOpns);
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		tlDriver.set(driver);
		
		return getDriver();

	}

	public static WebDriver getDriver() {
		
		WebDriver driver = tlDriver.get();
		if (driver == null) {
            // fallback or error
            throw new RuntimeException("WebDriver is not initialized. Call initializeBrowser() first.");
        }
        return driver;
	}
	
	public static void quitDriver()
	{
		WebDriver driver = tlDriver.get();
		if(driver != null)
			driver.quit();
			tlDriver.remove();
	}
}
