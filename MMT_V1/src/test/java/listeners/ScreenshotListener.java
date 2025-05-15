package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.DriverFactory;

public class ScreenshotListener implements ITestListener {

    private void saveScreenshot(String status, ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) return;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        File dest = new File("screenshots/" + status + "/" + result.getMethod().getMethodName() + "_" + timeStamp + ".png");
        
        try {
			FileUtils.forceMkdirParent(dest);
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot saved: " + dest.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot("failure_folder", result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveScreenshot("success_folder", result);
    }
}

