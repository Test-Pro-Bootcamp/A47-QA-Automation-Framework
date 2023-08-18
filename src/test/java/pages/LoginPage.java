package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement logInButton;

    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        logInButton.click();
    }
    public void logIn(){
        provideEmail("yuliyakis85@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    public void IncorrectLogIn(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    }