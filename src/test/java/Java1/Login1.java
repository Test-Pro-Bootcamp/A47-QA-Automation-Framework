package Java1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login1 {

    WebDriver driver;
    By EmailAdd=By.cssSelector("input[placeholder='Email Address']");
    By PasswordAdd=By.cssSelector("input[placeholder='Password']");
    By LoginBtn=By.cssSelector("button[type='submit']");

    Login1(WebDriver d)
    {
        driver=d;
        //this.driver=driver
    }

    public void setEmailAdd(String email)
    {
        driver.findElement(EmailAdd).sendKeys(email);
    }
    public void setPasswordAdd(String password)
    {
        driver.findElement(PasswordAdd).sendKeys(password);
    }
    public void clickLoginBtn()
    {
        driver.findElement(LoginBtn).click();
    }
}

