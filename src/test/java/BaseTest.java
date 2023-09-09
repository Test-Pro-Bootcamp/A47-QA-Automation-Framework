import io.github.bonigarcia.wdm.WebDriverManager;

import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void lunchBrowser(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    protected static void navigateToPage(){
        String url = "https://bbb.testPro.io/";
        driver.get(url);
    }

    public void provideEmail(String email){

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){

        WebElement passwordFiled = driver.findElement(By.cssSelector("[type='password']"));
        passwordFiled.clear();
        passwordFiled.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

    }}