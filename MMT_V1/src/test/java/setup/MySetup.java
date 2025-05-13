package setup;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MySetup {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		Properties prop = new ConfigReader().intializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browser")); // sets static driver internally
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ","_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioName);
		}
		
		if (driver != null) {
            driver.quit();
        }		
	
	}

}
