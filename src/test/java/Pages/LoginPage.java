package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements
    @FindBy (css = "[type='email']")
    private WebElement emailField;
    @FindBy (css = "[type='password']")
    private WebElement passwordField;
    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitBtn;


    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }
    public void login() {
        provideEmail("trianasahlin@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}
