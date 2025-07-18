package setup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ExtentReportManager;

public class Hooks {
    public static WebDriver driver;
    public static ExtentReports extent;
    private static ExtentTest extentTest;
    private static ThreadLocal<Integer> screenshotCounter = ThreadLocal.withInitial(() -> 1);

    @Before
    public void setup(Scenario scenario) {
        Properties prop = new ConfigReader().intializeProperties();
        driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
        System.out.println("WebDriver initialized");
        extent = ExtentReportManager.setupExtentReport();
        extentTest = extent.createTest(scenario.getName());
        Hooks.setExtentTest(extentTest);
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        if (driver != null) {
            try {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotName = "embedded" + screenshotCounter.get() + ".png";
                screenshotCounter.set(screenshotCounter.get() + 1);

                // Save screenshot to file
//                File screenshotFile = new File("Reports/SparkReport/" + screenshotName);
//                File parentDir = screenshotFile.getParentFile();
//                if (!parentDir.exists()) {
//                    parentDir.mkdirs();
//                    System.out.println("Created directory: " + parentDir.getAbsolutePath());
//                }
//                Files.write(screenshotFile.toPath(), screenshotBytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//                System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());

                // Attach to Cucumber scenario
                scenario.attach(screenshotBytes, "image/png", screenshotName);
                System.out.println("Attached to Scenario: " + screenshotName + ", Size: " + screenshotBytes.length + " bytes");

                // Attach to Extent Report using Base64
                if (extentTest != null) {
                    String base64String = Base64.getEncoder().encodeToString(screenshotBytes);
                    System.out.println("Base64 string length: " + base64String.length() + " for " + screenshotName);
                    extentTest.info("Screenshot for " + screenshotName);
                    extentTest.addScreenCaptureFromBase64String(base64String, screenshotName);
                    System.out.println("Attached to ExtentTest as Base64: " + screenshotName);
                } else {
                    System.out.println("Error: extentTest is null");
                }
            } catch (Exception e) {
                System.err.println("Error capturing or attaching screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) DriverFactory.quitDriver();
        if (extent != null) extent.flush();
    }

    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
        System.out.println("ExtentTest set");
    }
}