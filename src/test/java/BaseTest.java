import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit']"));
        submit.click();
    }

}
