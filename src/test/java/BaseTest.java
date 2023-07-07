import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static WebDriver driver = null;
    public static String  url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrouser (){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrouser(){
        driver.quit();
    }

    public void navigateToPage(){
        driver.get(url);
    }
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(By.cssSelector("[type=’email’]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword (String password){
        WebElement passwordInput = driver.findElement(By.cssSelector("[type=’password’]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginBatton(){
        WebElement submitLogin = driver.findElement (By.cssSelector(".avatar"));
        submitLogin.click();
    }
}