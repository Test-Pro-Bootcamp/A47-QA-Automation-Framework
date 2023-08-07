package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css ="[type = 'email']" )
           WebElement  emailField;

    @FindBy (css ="[type = 'password']" )
    WebElement  passwordField;

    @FindBy (css ="button[type = 'submit']")
    WebElement  submitBtn;

    public void loginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
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
    public void login(){
        provideEmail("beomseo.park@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
