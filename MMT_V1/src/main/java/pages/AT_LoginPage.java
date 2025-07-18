package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonUtils;
import utils.ElementUtils;

public class AT_LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AT_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Signup') or contains(text() , 'Login')]")
	private WebElement signUpLoginButton;
	
	@FindBy(xpath="//div[@class = 'col-sm-4 col-sm-offset-1']//div[@class = 'login-form']//h2[contains(text(), 'Login')]")
	private WebElement loginText;

	@FindBy(xpath = "//input[@data-qa = 'login-email']")
	private WebElement loginEmail;
	
	@FindBy(xpath = "//input[@data-qa = 'login-password']")
	private WebElement loginPassword;
	
	@FindBy(xpath="//button[@data-qa = 'login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//ul[contains(@class,'navbar-nav')]/li[a[contains(text(), 'Logged in as')]]")
	private WebElement loggedinText;
	
	@FindBy(xpath = "//p[text() = 'Your email or password is incorrect!']")
	private WebElement loginErrorText;
	
	public void clickOnSignInByMailButton()
	{
		elementUtils.clickOnElement(signUpLoginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyLoginMessage(String expectedLoginText)
	{
//		String expectedLoginText = "Login to your account";
		String actualLoginText = elementUtils.getTextFromElement(loginText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		Assert.assertEquals(actualLoginText, expectedLoginText);
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		elementUtils.typeTextIntoElement(loginEmail, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.typeTextIntoElement(loginPassword, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnLoginButton()
	{
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void verifyLoggedinMessage()
	{
		String expectedLoginText = "Logged in as TestQA0012";
		String actualLoginText = elementUtils.getTextFromElement(loggedinText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		Assert.assertEquals(actualLoginText, expectedLoginText);
	}
	
	public void verifyLoginErrorMessage(String expectedLoginErrorText)
	{
//		String expectedLoginText = "Logged in as";
		String actualLoginErrorText = elementUtils.getTextFromElement(loginErrorText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		Assert.assertEquals(actualLoginErrorText, expectedLoginErrorText);
	}
	
	
}
