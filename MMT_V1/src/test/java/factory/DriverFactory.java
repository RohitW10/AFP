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

	public static WebDriver driver = null;

	public static WebDriver initializeBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito", "--disable-notifications", "--start-maximized");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--inprivate", "--disable-notifications", "start-maximized");
			driver = new EdgeDriver(options);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--private", "--disable-notifications", "--start-maximized");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("safari"))
			driver = new SafariDriver();
		 else {
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver;

	}

	public static WebDriver getDriver() {

		if (driver == null) {
            // fallback or error
            throw new RuntimeException("WebDriver is not initialized. Call initializeBrowser() first.");
        }
        return driver;
	}
}
