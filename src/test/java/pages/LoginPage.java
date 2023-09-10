package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

        public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    @FindBy(css = "[type='email']")
            private WebElement emailField;

    @FindBy(css = "[type='password']")
           private WebElement passwordField;

    @FindBy(css = "[type='submit']")
            private WebElement submitBtn;


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
        providePassword("te$t$tudent1");
        clickSubmitBtn();
        return this;
    }
}


