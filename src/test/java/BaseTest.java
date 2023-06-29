import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);

    }
    @AfterMethod
    public void logout() {

        driver.quit();
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        //inputs valid email address into email input field
        emailInput.sendKeys(email);
    }

    protected static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        //inputs valid password for login into password field
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
    }

}