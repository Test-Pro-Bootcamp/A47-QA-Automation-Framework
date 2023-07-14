import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy (css="input[type='email']")
    WebElement emailField;

    //By emailField= By.cssSelector("input[type='email']");
    //By passwordField=By.cssSelector("input[type='password']");
    @FindBy (css="input[type='password']")
    WebElement passwordField;
    @FindBy (css="button[type='submit']")
    WebElement submitButtonLocator;

   // By submitBtn=By.cssSelector("button[type='submit']");
    public void provideEmail(String email){
        //findElement(emailField).sendKeys(email);
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
       // findElement(passwordField).sendKeys(password);
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        //findElement(submitBtn).click();
        submitButtonLocator.click();
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }


}
