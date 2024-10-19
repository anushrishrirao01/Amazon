package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
    @FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
    public AddToCartPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddToCart() {
    	addToCart.click();
    }
}
