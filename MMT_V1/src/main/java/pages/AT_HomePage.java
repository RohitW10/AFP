package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import utils.CommonUtils;
import utils.ElementUtils;

public class AT_HomePage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public AT_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Signup') or contains(text() , 'Login')]")
	private WebElement signUpLoginButton;
	
	@FindBy(xpath="//div[@class = 'col-sm-4']//div[@class = 'signup-form']//h2[contains(text(), 'Signup')]")
	private WebElement newUserSignUpText;
	
	@FindBy(xpath = "//input[@data-qa = 'signup-name']")
	private WebElement signUpName;

	@FindBy(xpath = "//input[@data-qa = 'signup-email']")
	private WebElement signUpEmail;
	
	@FindBy(xpath = "//button[@data-qa = 'signup-button']")
	private WebElement signUpButton;
	
	@FindBy(xpath = "//b[contains(text(), 'Account')]")
	private WebElement accountInfoText;
	
	@FindBy(xpath = "//input[@value = 'Mr']")
	private WebElement selectMr;
	
	@FindBy(xpath = "//input[@value = 'Mrs']")
	private WebElement selectMrs;
	
	@FindBy(xpath = "//input[@data-qa = 'name']")
	private WebElement inputName;
	
	@FindBy(xpath = "//input[@data-qa = 'email']")
	private WebElement inputEmail;
	
	@FindBy(xpath = "//iframe[@id='aswift_1']")
	private WebElement adiframe;
	
	@FindBy(xpath = "//input[@data-qa = 'password']")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//select[@data-qa = 'days']")
	private WebElement inputDay;
	
	@FindBy(xpath = "//select[@data-qa = 'months']")
	private WebElement inputMonth;
	
	@FindBy(xpath = "//select[@data-qa = 'years']")
	private WebElement inputYear;
	
	@FindBy(id = "newsletter")
	private WebElement checkNewsLetterBox;
	
	@FindBy(id = "optin")
	private WebElement checkOptInBox;
	
	@FindBy(xpath = "//input[@data-qa = 'first_name']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@data-qa = 'last_name']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//input[@data-qa = 'company']")
	private WebElement companyNameField;
	
	@FindBy(xpath = "//input[@data-qa = 'address']")
	private WebElement addressField;
	
	@FindBy(xpath = "//input[@data-qa = 'address2']")
	private WebElement address2Field;
	
	@FindBy(xpath = "//select[@data-qa = 'country']")
	private WebElement countryField;
	
	@FindBy(xpath = "//input[@data-qa = 'state']")
	private WebElement stateField;
	
	@FindBy(xpath = "//input[@data-qa = 'city']")
	private WebElement cityField;
	
	@FindBy(xpath = "//input[@data-qa = 'zipcode']")
	private WebElement zipCodeField;
	
	@FindBy(xpath = "//input[@data-qa = 'mobile_number']")
	private WebElement mobileField;
	
	@FindBy(xpath = "//button[@data-qa = 'create-account']")
	private WebElement clickCreateAccount;
	
	@FindBy(xpath = "//p[contains(text(), 'Congratulations')]")
	private WebElement createAccountMessage;
	
	public void verifyUserOnHomePage()
	{
		String actualPageTitle = elementUtils.getPageTitle();
		Assert.assertEquals(actualPageTitle, "Automation Exercise");
	}
	
	public void clickOnSignUpLoginButton()
	{
		elementUtils.clickOnElement(signUpLoginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyNewUserSignUpText()
	{
		elementUtils.getTextFromElement(newUserSignUpText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterSignUpNameAndEmail(String name, String emailAddress)
	{
		elementUtils.typeTextIntoElement(signUpName, name, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.typeTextIntoElement(signUpEmail, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnSignUpButton()
	{
		elementUtils.clickOnElement(signUpButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyAccountInfoText()
	{
		String actualText = elementUtils.getTextFromElement(accountInfoText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		Assert.assertEquals(actualText, "ENTER ACCOUNT INFORMATION");
	}
	
	public void selectTitle(String title)
	{
		elementUtils.scrollIntoView(driver, selectMr);
		if(title.equals("Mr"))
			elementUtils.clickOnElement(selectMr, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		else if(title.equals("Mrs"))
			elementUtils.clickOnElement(selectMrs, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyNameAndEmail(String actualName, String actualEmailAddress)
	{
		elementUtils.scrollIntoView(driver, inputName);
		String setName = elementUtils.getValueFromAttribute(inputName);
		Assert.assertEquals(actualName, setName);
		
		elementUtils.scrollIntoView(driver, inputEmail);
		String setEmail = elementUtils.getValueFromAttribute(inputEmail);
		Assert.assertEquals(actualEmailAddress, setEmail);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.scrollIntoView(driver, enterPassword);
		elementUtils.clickWithJS(driver, enterPassword);
		elementUtils.typeTextIntoElement(enterPassword, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterDOB(String day, String month, String year)
	{
		elementUtils.scrollIntoView(driver, inputDay);
		elementUtils.selectElementUsingValue(inputDay, day, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.selectElementUsingValue(inputMonth, month, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.selectElementUsingValue(inputYear, year, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	public void checkNewsLetterBox()
	{
		elementUtils.scrollIntoView(driver, checkNewsLetterBox);
		elementUtils.clickOnElement(checkNewsLetterBox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void checkOptInBox()
	{
		elementUtils.scrollIntoView(driver, checkOptInBox);
		elementUtils.clickOnElement(checkOptInBox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterFirstNameLastNameCompanyName(String firstName, String lastName, String companyName)
	{
		elementUtils.scrollIntoView(driver, firstNameField);
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, lastNameField);
		elementUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, companyNameField);
		elementUtils.typeTextIntoElement(companyNameField, companyName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterAddressDetails(String address, String address2, String country, String state, String city, String zipcode, String mobileNo)
	{
		elementUtils.scrollIntoView(driver, addressField);
		elementUtils.typeTextIntoElement(addressField, address, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, address2Field);
		elementUtils.typeTextIntoElement(address2Field, address2, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, countryField);
		elementUtils.selectElementUsingValue(countryField, country, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, stateField);
		elementUtils.typeTextIntoElement(stateField, state, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, cityField);
		elementUtils.typeTextIntoElement(cityField, city, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, zipCodeField);
		elementUtils.typeTextIntoElement(zipCodeField, zipcode, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.scrollIntoView(driver, mobileField);
		elementUtils.typeTextIntoElement(mobileField, mobileNo, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickCreateAccountButton()
	{
		elementUtils.scrollIntoView(driver, clickCreateAccount);
		elementUtils.clickOnElement(clickCreateAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyAccountCreated()
	{
		elementUtils.scrollIntoView(driver, createAccountMessage);
		String actualText = elementUtils.getTextFromElement(createAccountMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		Assert.assertEquals(actualText, "Congratulations! Your new account has been successfully created!");
	}
	
	
	
}
