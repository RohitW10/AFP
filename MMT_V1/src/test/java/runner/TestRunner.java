package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/AT_Login.feature",
				 glue={"stepdefinitions","setup"},
				 plugin = {"pretty",
							"html:target/cucumber-reports.html",
							"json:target/cucumber.json",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							    },
				    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true) // Enables parallel scenario execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}