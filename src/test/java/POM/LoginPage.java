package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

By emailField = By.cssSelector("input[type='email']");

By passwordField = By.cssSelector("input[type='password']");

By submitBtn = By.cssSelector("button[type='submit']");

public void provideEmail (String email) {
    findElement(emailField).sendKeys(email);
}

public void providePassword (String password) {
    findElement(passwordField).sendKeys(password);
}
 public void clickSubmit () {
    findElement(submitBtn).click();
 }

 public void login() {
     provideEmail("erika.olsen@testpro.io");
     provideEmail("te$t$tudent");
     clickSubmit();
 }
}