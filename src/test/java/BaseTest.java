import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public static WebDriverManager driver = null;
    public static String url = ("https://qa.koel.app/");

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    protected static void openLoginUrl() {
        String url = ("https://qa.koel.app/");
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys("irene.perdon@testpro.io");
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.getWebDriver(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void clickSubmit() {
        WebElement submit = driver.getWebDriver().findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}