package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");
    private By submitButton = By.cssSelector("button[type='submit']");

    public void enterEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickButton() {
        findElement(submitButton).click();
    }

    public void login() {
        enterEmail("neelam.gupta@testpro.io");
        enterPassword("te$t$tudent1");
        clickButton();
    }
}