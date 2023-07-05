import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;




public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

    @DataProvider (name = "LoginProviders")
    public static Object [][] getLoginData(){
        return new Object[][]{
                {"yana.kurenko@testpro.io", "te$t$tudent"}
        };

    }

    public static void enterEmail (String email){
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public static void enterPassword (String password){
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public static void clickLoginButton (){
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type = 'submit']")));
        loginButton.click();



    }


}