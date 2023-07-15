package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

        public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    @FindBy(css = "[type='email']")
            protected WebElement emailField;

    @FindBy(css = "[type='password']")
           protected WebElement passwordField;

    @FindBy(css = "[type='submit']")
            protected WebElement submitBtn;


    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn () {
        submitBtn.click();
        return this;
    }

    public LoginPage login () {
        provideEmail("matt.pierce@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }
}


