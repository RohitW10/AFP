package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AT_HomePage;
import setup.MySetup;

public class AT_SD_Register {

	WebDriver driver;
	AT_HomePage homePage;

	
	@Given("^User navigates to home page$")
	public void user_navigates_to_home_page() {

		driver = DriverFactory.getDriver();
	}

	@And("Home Page is accessed successfully")
	public void home_page_is_accessed_successfully() {

		homePage = new AT_HomePage(driver);
		homePage.verifyUserOnHomePage();

	}

	@And("User clicks on User Sign Up button")
	public void user_clicks_on_user_sign_up_button() {

		homePage.clickOnSignUpLoginButton();

	}

	@And("User is able to view to New User SignUp section")
	public void user_is_able_to_view_to_new_user_sign_up_section() {

		homePage.verifyNewUserSignUpText();
	}

	@And("^User enters (.+) and (.+)$")
	public void user_enters_name_and_email_address(String name, String emailAddress) {

		homePage.enterSignUpNameAndEmail(name, emailAddress);
	}

	@And("User clicks on Sign Up button")
	public void user_clicks_on_sign_up_button() {
		
		homePage.clickOnSignUpButton();
	}

	@And("User is able to view new user account info page")
	public void user_is_able_to_view_new_user_account_info_page() {

		homePage.verifyAccountInfoText();
	}

	@And("^User selects (.+), verifies (.+) and (.+), enters (.+), DOB in (.+),(.+),(.+) format$")
	public void user_selects_title_verifies_name_and_email_enters_password_dob(String title, String name, String emailAddress, String password, String day, String month, String year) {
		
		homePage.selectTitle(title);
		homePage.verifyNameAndEmail(name, emailAddress);
		homePage.enterPassword(password);
		homePage.enterDOB(day, month, year);
		
		
	}

	@And("User clicks on Sign up for our newsletter!")
	public void user_clicks_on_sign_up_for_our_newsletter() {

		homePage.checkNewsLetterBox();
	}

	@And("User clicks on Receive special offers from our partners!")
	public void user_clicks_on_receive_special_offers_from_our_partners() {

		homePage.checkOptInBox();
	}

	@And("^User fills personal details like (.+), (.+), (.+)$")
	public void user_fills_details_of_first_name_last_name_company(String firstName, String lastName, String companyName) {

		homePage.enterFirstNameLastNameCompanyName(firstName, lastName, companyName);
	}

	@And("^User fills details like (.+), (.+), (.+), (.+), (.+), (.+) & (.+)$")
	public void user_fills_details_of_address_address2_country_state_city_zip_code_mobile_no(String address, String address2, String country, String state, String city, String zipcode, String mobileNo) {

		homePage.enterAddressDetails(address, address2, country, state, city, zipcode, mobileNo);
	}

	@And("User clicks on Create Account button")
	public void user_clicks_on_create_account_button() {

		homePage.clickCreateAccountButton();
	}

	@Then("User should see account created message")
	public void user_should_see_account_created_message() {

		homePage.verifyAccountCreated();
	}

}
