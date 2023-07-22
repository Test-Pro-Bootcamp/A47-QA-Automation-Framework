package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        //This method initializes the WebDriver using the super (givenDriver)
        super(givenDriver);
    }
    private By emailFieldLocator = By.cssSelector("[type = 'email']");
    private By passwordFieldLocator = By.cssSelector("[type = 'password']");
    private By submitButtonLocator = By.cssSelector("[type = 'submit']");

    // Login
    //-------------------------
    public void provideEmail(String email) {
        findElementClickable(emailFieldLocator).sendKeys(email);
    }
    public void providePW(String password) {
        findElementClickable(passwordFieldLocator).sendKeys(password);
    }
    public void clickSubmit() {
        findElementClickable(submitButtonLocator).click();
    }
    public void login(){
        provideEmail("teststudent@teststudent.com");
        providePW("te$t$tudent");
        clickSubmit();
    }
}
