package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");

    By submitBtn = By.cssSelector("button[type = 'submit']");

    public void loginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("beomseo.park@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
