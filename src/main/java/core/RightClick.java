package core;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RightClick {
	static String in_browser = "Edge"; // "HtmlUnit" "Firefox" "Chrome"  "Safari"  "IE"  "Edge"

	//static String url = "http://ebay.com/";
	static 	String url = "http://swisnl.github.io/jQuery-contextMenu/demo.html";
	
	public static void rightClick(WebElement element) {
		try {
			Actions action = new Actions(Browsers.driver).contextClick(element);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	}
	
public static void main(String[] args) throws IOException, InterruptedException {
	Browsers.setWebDriver(in_browser);
	WebDriver driver = Browsers.driver;
	
	driver.get(url);Thread.sleep(2000);
		driver.navigate().to(url);
		By locator = By.xpath("html/body/div[1]/section/div/div/div/p/span"); // <span class="context-menu-one btn btn-neutral">right click me</span>
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
		
		WebElement element=driver.findElement(locator);
		rightClick(element);
		//<li class="context-menu-item context-menu-icon context-menu-icon-edit"><span>Edit</span></li>
		WebElement elementEdit =driver.findElement(By.xpath("html/body/ul/li[1]"));
		elementEdit.click();
		Alert alert=driver.switchTo().alert();
		String textEdit = alert.getText();
		System.out.println("textEdit: "+textEdit);
		if (Browsers.driver != null) {Browsers.driver.quit();}
	}
	
}
