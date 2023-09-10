package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(css = "[type = 'email']")
    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));

    @FindBy(css = "[type = 'password']")
    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));

    @FindBy(css = "button[type = 'submit']")
    WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));

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

    public void login() {
        provideEmail("beomseo.park@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

    }
}
