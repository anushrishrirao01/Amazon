package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ReturnAndOrders;
import popUp.SignInPage;

public class ReturnAndOrdersFunctionality {
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signIn;
	private ReturnAndOrders returnAndOrders;
	
	@Parameters("browser")
	
	@BeforeTest
	void launchBrowser(String expectedBrowser) {
		System.out.println(expectedBrowser);
		
		if(expectedBrowser.equals("Chrome")) {
	    driver = new ChromeDriver();
	    }
		
		if(expectedBrowser.equals("Firefox")) {
		    driver = new FirefoxDriver();
		    }
		
		if(expectedBrowser.equals("Edge")) {
		    driver = new EdgeDriver();
		    }
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }
	
   @BeforeClass 
   void initializePomObject() throws InterruptedException {
	   homePage = new HomePage(driver);
	   signIn = new SignInPage(driver);
		Thread.sleep(3000);
		returnAndOrders = new ReturnAndOrders(driver);
		   Thread.sleep(3000);
   }
   
   
   @BeforeMethod
    void launchApplication() throws InterruptedException {
    	 driver.navigate().to("https://www.amazon.in");
    	 
 		homePage.clickOnAccountAndList();
 		//Thread.sleep(3000);
 	
		 signIn.enterEmail("anushreegodbole15@gmail.com");;
	 //	Thread.sleep(3000);
         signIn.clickOnContinueButton();
		 signIn.enterPassword("anushri123");
	    	//Thread.sleep(3000);
		 signIn.clickOnSignInButton();
	    	//Thread.sleep(2000);
    }
   
   @Test
   void returnAndOrders() throws InterruptedException {
	
	   homePage.clickOnReturnAndOrders();
	   Thread.sleep(3000);
	   
	   returnAndOrders.clickOnOrderPlacedIn();
	   Thread.sleep(1000);
	   returnAndOrders.scroll();
   }
   
   @AfterMethod
   void closeApplication() throws InterruptedException {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account & Lists']")));
	   
       homePage.logOut();
   }
   
   @AfterClass
   void removePOM() {
		 homePage=null;
		 signIn  = null;
		 returnAndOrders= null;	
   }
   
   @AfterTest
   void closeBrowser() {
	   driver.quit();
   }
}
