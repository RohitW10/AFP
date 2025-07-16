package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/AT_Login.feature",
				 glue={"stepdefinitions","setup"},
				 plugin = {"pretty",
							"html:target/cucumber-reports.html",
							"json:target/cucumber.json"
							    },
				    monochrome = true
)

//@Listeners(ScreenshotListener.class)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true) // Enables parallel scenario execution
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
