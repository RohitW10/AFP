package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class MMT_LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public MMT_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//img[@data-cy = 'signInByMailButton']")
	private WebElement mailButton;
	
	@FindBy(xpath="//input[@data-cy = 'userName']")
	private WebElement emailField;
	
	@FindBy(xpath="//button[@data-cy = 'continueBtn']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@data-cy = 'password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@data-cy = 'login']")
	private WebElement loginButton;
	
	public void clickOnSignInByMailButton()
	{
		elementUtils.clickOnElement(mailButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		elementUtils.typeTextIntoElement(emailField, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnContinue()
	{
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnLoginButton()
	{
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
}
