package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import tests.AddToCartFunctionality;
// Base class/ base/ pojo/ browser
public class Browser {

	public static WebDriver launchChromeBrowser() {
	
		
		
		
		

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-Notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		return driver;
	}
	
	public static WebDriver launchFirefoxBrowser() {
		//FirefoxOption
	
		FirefoxOptions user_pref = new FirefoxOptions();
		user_pref.addPreference("dom.webnotifications.enabled", false);
		
		WebDriver driver = new FirefoxDriver(user_pref);
		return driver;
		
	}
	
	public static WebDriver launchEdgeBrowser() {
		
		EdgeOptions edge = new EdgeOptions();
		edge.addArguments("disable-notifications");
		
		WebDriver driver = new EdgeDriver(edge);
		return driver;
	}
	
	
	public static WebDriver launchBrowser(String targetBrowser) {
		WebDriver driver= null;
		System.out.println(targetBrowser);
		
		if(targetBrowser.equals("Chrome") ) {
		driver = AddToCartFunctionality.launchChromeBrowser();  //using sub-classname
		}
		
		if(targetBrowser.equals("Firefox") ) {
			driver = Browser.launchFirefoxBrowser();  //using super-classname
			}
		
		if(targetBrowser.equals("Edge") ) {
			driver = launchEdgeBrowser();    // using inherited static method
			}
		
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	return driver ;
	}
}
