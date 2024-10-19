package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReturnAndOrders {
    

    @FindBy (xpath="//select[@id='time-filter']")
    private WebElement dropDown;
    
    @FindBy (xpath="(//div[@class='order-card js-order-card'])[4]")
    private WebElement scrollUpto;
    
    private WebDriver driver;
    public ReturnAndOrders(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    	//driver = new ChromeDriver();
    	this.driver=driver;
    }
    
  
    public void clickOnOrderPlacedIn() {
    	//dropDown.click();
    	Select s = new Select(dropDown);
    	s.selectByValue("year-2024");
    }
    
    public void scroll() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeAsyncScript("window.scrollBy(0, 900)");
 	  // js.executeAsyncScript("arguments[0].scrollIntoView(true);", scrollUpto);
    }
    
    
    
}
