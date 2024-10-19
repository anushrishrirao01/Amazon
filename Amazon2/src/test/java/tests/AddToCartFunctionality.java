package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pages.AddToCartPage;
import pages.GoToCartPage;
import pages.HomePage;
import pages.SearchItemPage;
import popUp.SignInPage;

public class AddToCartFunctionality extends Browser
{
	private WebDriver driver;
	private HomePage  homePage;
	private SignInPage signIn;
	private SearchItemPage searchItemPage;
	private AddToCartPage addToCartPage;
	private GoToCartPage goToCartPage;
	private List<String> addr;
	
	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser) {
		System.out.println(expectedBrowser);
		driver= launchBrowser(expectedBrowser);
	}
	
    @BeforeClass
    void initializePomObject() throws InterruptedException {
    	homePage = new HomePage(driver);
    	signIn = new SignInPage(driver);
    	Thread.sleep(3000);
    	searchItemPage = new  SearchItemPage(driver);
      	Thread.sleep(3000);
      	addToCartPage = new AddToCartPage(driver);
      	Thread.sleep(3000);
      	goToCartPage = new GoToCartPage(driver);
      	Thread.sleep(3000);
    }
    @BeforeMethod
    void launchApplication() throws InterruptedException {
    	driver.navigate().to("https://www.amazon.in");      
    }
    
    @Test(priority=0)
    void addToCart() throws InterruptedException   
    {
	 homePage.clickOnAccountAndList();
	 Thread.sleep(3000);
     //homePage.clickOnSignInButton();
	 Thread.sleep(3000);
	 signIn.enterEmail("anushreegodbole15@gmail.com");;
   	Thread.sleep(3000);
    signIn.clickOnContinueButton();
	signIn.enterPassword("anushri123");
    Thread.sleep(3000);
     signIn.clickOnSignInButton();
    Thread.sleep(5000);
     }
    
    @Test (priority=1)
    void searchAndAddToCart() throws InterruptedException {
      
      searchItemPage.enterProductName("women kurti");
  	Thread.sleep(3000);
  	searchItemPage.clickOnSearchButton();
  	Thread.sleep(3000);
    searchItemPage.selectFirstProduct();
  	Thread.sleep(3000);

  	addr =  new ArrayList<String>(driver.getWindowHandles());
  	driver.switchTo().window(addr.get(1));
  	
  	addToCartPage.clickOnAddToCart();
  	Thread.sleep(3000);
  	driver.switchTo().defaultContent();
  	Thread.sleep(3000);
  	goToCartPage.clickOnGoToCart();
  	Thread.sleep(3000);

    }
    
    @AfterMethod
    void closeApplication() throws InterruptedException {
    	driver.switchTo().window(addr.get(0));
    	driver.close();
    	
    	Thread.sleep(5000);
        homePage.logOut();
    }
    
    @AfterClass
    void removePOM() {
		homePage=null;
		signIn=null;
		searchItemPage=null;
		addToCartPage=null;
		goToCartPage=null;
		System.gc();
    }
    @AfterTest
    void closeBrowser() {
    	driver.quit();
    }
    
    
}
