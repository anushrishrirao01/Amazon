package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage {

	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement productSearchBox;
	
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement SearchButton;
	
	@FindBy (xpath="(//div[@class='sg-col-inner'])[6]")
	private WebElement selectedProduct;
	
	public SearchItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	
	public void enterProductName(String productname) {
		productSearchBox.click();
		productSearchBox.sendKeys(productname);
	}
	
	public void clickOnSearchButton() {
		SearchButton.click();
	}
	public void selectFirstProduct() {
		selectedProduct.click();
	}
	
	
	
	
}
