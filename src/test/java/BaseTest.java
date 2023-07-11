import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected String url;

    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    @Parameters({"baseUrl"})
    protected void initializeBrowser(String baseUrl){
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        actions = new Actions(driver);
    }

    @AfterMethod
    protected void quitBrowser(){
//        Quit browser
        driver.quit();
    }

    @DataProvider(name="ValidLoginData")
    public static Object[][] validParams(){
        return new Object[][]{
                {"daviyontae.floyd@testpro.io", "te$t$tudent"},
        };
    }
    @DataProvider(name="InvalidLoginData")
    public static Object[][] invalidParams(){
        return new Object[][]{
                {"daviyontae.floyd@testpro.io", ""},
                {"invalid.email@gamil.com", "te$t$tudent"},
                {"", ""}
        };
    }
}