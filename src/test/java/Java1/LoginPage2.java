package Java1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

    WebDriver driver;
    //    @FindBy(how = How.CSS, using ="input[placeholder='Email Address']")
//    WebElement EmailAdd;
//
//    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
//    WebElement PasswordAdd;
//
//    @FindBy(how =How.CSS, using = "button[type='submit']")
//    WebElement LoginBtn;
//
    //locator //    value
    @FindBy(css = "input[placeholder='Email Address']")
    WebElement EmailAdd;

    @FindBy(css ="input[placeholder='Password']")
    WebElement PasswordAdd;

    @FindBy(css ="button[type='submit']")
    WebElement LoginBtn;

    LoginPage2(WebDriver d) {
        driver = d;
        PageFactory.initElements(d,this);
    }


    public void setEmailAdd(String email)
    {
     EmailAdd.sendKeys(email);
    }

    public void setPasswordAdd(String password){
        PasswordAdd.sendKeys(password);
    }
    public void clickLoginBtn()
    {
        LoginBtn.click();
    }
}




