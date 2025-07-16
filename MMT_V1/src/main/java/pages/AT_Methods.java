package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AT_Methods {

	public void testMethod() throws NullPointerException {
		WebDriver driver = new ChromeDriver();
		
		WebElement  el = driver.findElement(By.id("name"));
		el.clear();
		el.click();
		el.sendKeys("test");
		el.isSelected();
		el.isDisplayed();
		el.isEnabled();
		
		driver.findElement(By.id("name"));
		driver.findElement(By.name("name"));
		driver.findElement(By.className("name"));
		driver.findElement(By.tagName("name"));
		driver.findElement(By.linkText("name"));
		driver.findElement(By.partialLinkText("name"));
		driver.findElement(By.cssSelector("input[type = name ]"));
		driver.findElement(By.xpath("//input[@type = name ]"));

		List<WebElement> list = driver.findElements(By.id("name")); 
		Iterator<WebElement> it = list.iterator();
		driver.get("https://www.google.co.in");
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getTitle();
		driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		driver.close();
		driver.quit();
		
		driver.switchTo().frame(0);
		driver.switchTo().frame("frameName");
		WebElement element = driver.findElement(By.id("name"));
		driver.switchTo().frame(element);
		driver.switchTo().window("windowName");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().activeElement();
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("name");
		driver.switchTo().alert().getText();
		
		driver.navigate().to("https://www.google.co.in");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

		
		Cookie cookie = new Cookie("name", "value", "domain", "path", new Date(), true);
		driver.manage().addCookie(cookie);
		driver.manage().getCookies();
		driver.manage().getCookieNamed("cookieName");
		driver.manage().deleteCookie(cookie);
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("cookieName");
		
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().getScriptTimeout();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.manage().window().getPosition();
		Point p = new Point(130,120);
		driver.manage().window().setPosition(p);
		driver.manage().window().getSize();
		Dimension d = new Dimension(200, 300);
		driver.manage().window().setSize(d);
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().window().minimize();
				
	}
}
