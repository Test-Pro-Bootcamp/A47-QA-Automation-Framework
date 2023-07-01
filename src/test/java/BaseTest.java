import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    public static WebDriverWait wait = null; //ADDED THIS HW20

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(String baseUrl) {

        ChromeOptions options = new ChromeOptions();

        //added chromeoptions argument to fix websocket error
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        // driver = new ChromeDriver(); //ADDED THIS HW20
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = baseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8)); //ADDED THIS HW20

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();


    }

}