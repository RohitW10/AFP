package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AT_HomePage;
import pages.AT_LoginPage;

public class AT_SD_Login {

	WebDriver driver;
	AT_LoginPage loginPage;
	AT_HomePage homePage;
	
//	@Given("^User navigates to home page$")
//	public void user_navigates_to_home_page() {
//	    
//		driver = DriverFactory.getDriver();
//	}

	@And("^User clicks on Sign In with Email button$")
	public void user_clicks_on_sign_in_with_email_button() throws InterruptedException {
	    
		Thread.sleep(2000);

		if (loginPage == null) {
		    loginPage = new AT_LoginPage(driver);
		}
		loginPage.clickOnSignInByMailButton();
		
		Thread.sleep(5000);

		
	}

	@And("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailAddress) throws InterruptedException {
	    
		loginPage.enterEmailAddress(emailAddress);
		Thread.sleep(5000);
	}

	@And("^User clicks on Continue$")
	public void user_clicks_on_continue() throws InterruptedException {
	
		loginPage.clickOnContinue();
		Thread.sleep(5000);

	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String password) throws InterruptedException {
	    
		loginPage.enterPassword(password);
		Thread.sleep(5000);

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws InterruptedException {
	 
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);

	}

	@And("^User enters received OTP and clicks Login$")
	public void user_enters_received_otp() throws InterruptedException {
	    
		System.out.println("User is entering OTP");
		Thread.sleep(2000);
	}

	@Then("^User should get successfully logged in$")
	public void user_should_get_successfully_logged_in() {
	    
		//Verifying user has logged in
		homePage = new AT_HomePage(driver);

	}
}
