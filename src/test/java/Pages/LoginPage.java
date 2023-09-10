package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){ super(givenDriver); }

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void enterEmail(String email){ findElement(emailField).sendKeys(email); }

    public void enterPassword(String password){ findElement(passwordField).sendKeys(password); }

    public void clickSubmit(){ click(submitBtn); }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
