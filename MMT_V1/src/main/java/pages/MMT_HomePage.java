package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class MMT_HomePage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public MMT_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//p[@data-cy='loggedInUser']")
	private WebElement loggedInUser;
	
	@FindBy(xpath="//p[contains(text(), 'You are viewing your personal profile')]")
	private WebElement loggedInText;
	
	
	public String verifyUserOnHomePage()
	{
		elementUtils.mouseHover(loggedInUser, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return elementUtils.getTextFromElement(loggedInText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
