import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.bouncycastle.cms.RecipientId.password;

public class LOGIN extends BASE {


    public LOGIN(WebDriver givenDriver) {
        super(givenDriver);
    }
    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElement(submitButton).click();
    }

    public void login() {
        provideEmail("courtney.matthews@testpro.io");
        providePassword("Walkonby08!!");
        clickSubmit();
    }
}
