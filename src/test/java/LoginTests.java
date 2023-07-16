import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the URL for the web page on the Chrome Browser
        String url = "https://qa.koel.app/";
        driver.get(url);

        // Put the email field inside the web page

       WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
       emailField.click();
       emailField.clear();
       emailField.sendKeys("andrea.guevara@testpro.io");


        // Put the password field inside the web page

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        //click on the submit button
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        // check if the user avatar is displaying

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        //Quit the browser

        driver.quit();


       //  Assert.assertEquals(driver.getCurrentUrl(), url);
       //   driver.quit();
    }
}
