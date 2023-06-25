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
    public void SuccessfulLoginTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      Open the url in Chrome
        String url = "https://qa.koel.app/";
        driver.get(url);

//        Enter email into the email field
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

//        Click the Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

//        Verify user is logged in by avatar display
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

//        Quit browser
        driver.quit();
    }

    @Test
    public void IncorrectLoginTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      Open the url in Chrome
        String url = "https://qa.koel.app/";
        driver.get(url);

//        Enter email into the email field
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("invalid.email@testpro.io");

//        Enter password into the password field
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

//        Click the Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

//        Check that user is still on the Login page and the Login button is still displayed
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(loginButton.isDisplayed());

//        Quit browser
        driver.quit();
    }

    @Test
    public void EmptyPasswordFieldTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      Open the url in Chrome
        String url = "https://qa.koel.app/";
        driver.get(url);

//        Enter email into the email field
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(" ");

//        Click the Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

//        Check that user is still on the Login page and the Login button is still displayed
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(loginButton.isDisplayed());

//        Quit browser
        driver.quit();
    }
}
