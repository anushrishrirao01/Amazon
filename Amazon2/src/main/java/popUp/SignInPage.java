package popUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy (xpath="//input[@name='email']")
	private WebElement emailTextBox;
    
    @FindBy (xpath="//input[@id='continue']")
	private WebElement continueButton;
    
    @FindBy (xpath="//input[@id='ap_password']")
	private WebElement passwordTextBox;
    
    @FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signIn;
    
    private WebDriver driver;
    public SignInPage (WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
    
    
    public void enterEmail(String email) {
    	emailTextBox.click();
    	emailTextBox.sendKeys(email);
    	
    }
    public void clickOnContinueButton() {
    	continueButton.click();
    }
    
    public void enterPassword(String password) {
    	passwordTextBox.click();
    	passwordTextBox.sendKeys(password);
    }
    
    public void clickOnSignInButton()  {
    	signIn.click();
    	
    	
    }
}
