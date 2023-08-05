import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        driver.manage().window().maximize();
//        Is same as:
//        options.addArguments("--start-maximized");
        actions = new Actions(driver);
        url = baseURL;
        driver.get(url);
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @DataProvider(name = "CorrectLoginProvider")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"teststudent@teststudent.com", "te$t$tudent"},
        };
    }
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getIncorrectLoginData() {
        return new Object[][]{
                // unregistered email/ correct password
                {"false@testpro.io", "te$t$tudent"},

                // registered email/ Incorrect password
                {"teststudent@teststudent.com", "nonExi$ting"},

                // registered email/ empty password
                {"teststudent@teststudent.com", ""},

                // empty email/ correct password
                {"", "te$t$tudent"},

                // empty email/ empty password
                {"", ""},
        };
    }
}
