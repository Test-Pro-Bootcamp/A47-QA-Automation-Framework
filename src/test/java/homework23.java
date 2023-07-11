import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class homework23 extends BasePage {


    WebDriver driver;//

    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;



    public homework23(WebDriver d)  //
    {
        driver=d;
        //this.driver=driver
    }

    public void provideEmail(String email) {emailField.sendKeys(email);}

    public void providePassword(String password) {passwordField.sendKeys(password);}

    public void clickSubmit() {submitBtn.click();}

    public void login() {
    }

}