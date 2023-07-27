package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }

   // By emailField = By.cssSelector("input[type= 'email']");
    @FindBy(css = "[type = 'email']")
    WebElement emailField;
    //By passwordField = By.cssSelector("input[type= 'password']");
    @FindBy (css = "[type = 'password']")
    WebElement passwordField;
    //By submitBtn = By.cssSelector("button[type= 'submit']");
    @FindBy (css = "button[type= 'submit']")
    WebElement submitBtnLocator;

    public void provideEmail(String email){
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
      submitBtnLocator.click();}

    public void login(){
        provideEmail("victor.flores@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
