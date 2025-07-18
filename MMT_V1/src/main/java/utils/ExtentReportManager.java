package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    public static ExtentReports setupExtentReport() {
        File reportDir = new File("Reports/SparkReport");
        reportDir.mkdirs();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/SparkReport/Spark.html");
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("Test Results");
        spark.config().setOfflineMode(true);
        spark.config().setEncoding("UTF-8");
        spark.config().enableOfflineMode(true);
//        spark.config().setResourcePath(""); // Disable file-based paths
//        spark.setAppendExisting(false); // Ensure fresh report
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", System.getProperty("browser", "Chrome"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Project", "MyCucumberBDD");
        System.out.println("ExtentReports configured with SparkReporter at: Reports/SparkReport/Spark.html");
        return extent;
    }
}