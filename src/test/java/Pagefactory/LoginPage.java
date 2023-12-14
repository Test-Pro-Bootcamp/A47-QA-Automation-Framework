package Pagefactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v105.css.CSS;
import org.openqa.selenium.support.FindBy;


public class LoginPage  extends BasePage{
    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;



    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }


    public LoginPage providePassword (String password){
        passwordField.sendKeys(password);
        return this;
    }


    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }



    public void Login(){
        provideEmail("andrea.guevara@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}

