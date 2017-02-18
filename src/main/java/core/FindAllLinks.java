package core;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAllLinks {
	static String in_browser = "Edge"; // "HtmlUnit" "Firefox" "Chrome"  "Safari"  "IE"  "Edge"
	static String url = "http://ebay.com/";
	
public static void main(String[] args) throws IOException, InterruptedException {
	Browsers.setWebDriver(in_browser);
	WebDriver driver = Browsers.driver;     
	driver.get(url);
	
	List<WebElement> links = driver.findElements(By.tagName("a")); // find all links
	System.out.println("links: \t\t"+links.size()); 
/*	Thread.sleep(1000);
	System.out.println(links.size());     
	for (int i = 0; i<links.size(); i=i+1){System.out.println(links.get(i).getText());}*/
	
	List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']")); 
	System.out.println("checkboxes: \t"+checkboxes.size()); //Find total number of Checkboxes on a Webpage 

	List<WebElement> dropdown = driver.findElements(By.tagName("select"));   
	System.out.println("dropdown: \t"+dropdown.size());  //Find total number of Menus on a Webpage 
	
	java.util.List<WebElement> textboxes = driver.findElements(By.xpath("//input[@type='text']")); 
	System.out.println("textboxes: "+textboxes.size()); //Find total number of TextBoxes on a Webpage
	
	if (Browsers.driver != null) {Browsers.driver.quit();}
	}}// FindAllLinks END
