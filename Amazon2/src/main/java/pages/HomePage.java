package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement accountAndList;
    
    @FindBy (xpath="//span[text()='Sign in']")
    private WebElement signIn;
    
    @FindBy (xpath="//a[@id='nav-orders']")
	private WebElement returnAndOrders;
    
    @FindBy (xpath="//span[text()='Sign Out']")
    private WebElement signOut;
    
    
    private WebDriver driver;
    
    private Actions act;
    
    public HomePage(WebDriver driver) {
    	
    	PageFactory.initElements(driver, this);
    	this.driver = driver;
        act = new Actions(driver);
    }
    
    public void clickOnAccountAndList() {
    	act = new Actions(driver);
    	act.moveToElement(accountAndList).moveToElement(signIn).click().perform();
    	//act.moveToElement(signIn).click().perform();
    }
    
    public void clickOnReturnAndOrders() {
    	returnAndOrders.click();
    }
    
  public void logOut() {
	  act = new Actions(driver);
   act.moveToElement(accountAndList).moveToElement(signOut).click().perform();
   
}
}