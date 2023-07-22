package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;
    @FindBy(css = "a[type='submit']")
    private WebElement registrationLink;

    public LoginPage enterEmail(String email){findElement(emailField).sendKeys(email); return this;}
    public LoginPage enterPassword(String password){findElement(passwordField).sendKeys(password); return this;}
    public LoginPage clickSubmit(){ click(submitBtn); return this;}
    public LoginPage login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return this;
    }
    public LoginPage verifyUserNotLoggedIn(){
        Assert.assertTrue(registrationLink.isDisplayed());
        return this;
    }
}
