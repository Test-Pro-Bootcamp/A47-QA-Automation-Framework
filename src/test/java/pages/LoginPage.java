package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    public void enterEmail(String email){ emailField.sendKeys(email); }

    public void enterPassword(String password){ passwordField.sendKeys(password); }

    public void clickSubmit(){ click(submitBtn); }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
