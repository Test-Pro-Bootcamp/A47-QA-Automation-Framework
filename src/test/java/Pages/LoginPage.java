package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        //This method initializes the WebDriver using the super (givenDriver)
        super(givenDriver);
    }
    //WebElements
   @FindBy (css = "[type = 'email']")
   private WebElement emailField;
    @FindBy (css = "[type = 'password']")
    private WebElement passwordField;
    @FindBy (css = "[type = 'submit']")
    private WebElement submitButton;

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePW(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }
    public void login(){
        provideEmail("teststudent@teststudent.com");
        providePW("te$t$tudent");
        clickSubmit();
    }
}
