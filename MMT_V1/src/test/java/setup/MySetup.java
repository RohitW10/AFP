package setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MySetup {

	public static WebDriver driver;

	@Before
	public void setup() {

		Properties prop = new ConfigReader().intializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browser")); // sets static driver internally
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("WebDriver initialized and navigated to: " + prop.getProperty("url"));

	}

	@AfterStep
	public void tearDown(Scenario scenario) throws IOException {
		driver = DriverFactory.getDriver();

		try {
			
            if (driver != null && ((RemoteWebDriver) driver).getSessionId() != null) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		String folder = scenario.isFailed() ? "failure_folder" : "success_folder";
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String stepScreenshotName = folder + "/" + scenarioName + "_" + timeStamp + ".png";
		File dest = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + stepScreenshotName);
		dest.getParentFile().mkdirs();

			FileUtils.copyFile(src, dest);
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Step Screenshot");
		}
		} catch (WebDriverException | IOException e) {
            System.out.println("Skipped screenshot due to WebDriver issue: " + e.getMessage());
        }

	}
	
	@After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
