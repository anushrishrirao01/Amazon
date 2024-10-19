package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCartPage {
    @FindBy (xpath="(//span[@class='a-button-inner']//a[@class='a-button-text'])[3]")
	private WebElement goToCart;
    
    
    public GoToCartPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void clickOnGoToCart() {
    	goToCart.click();
    }
    
}
