import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";
    public static Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
//    public static WebDriver pickBrowser(String browserName){
//        switch(browserName){
//            case "firefox":
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            case "MSEdge":
//                WebDriverManager.edgedriver();
//                driver = new EdgeDriver();
//
//        }
//    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    static void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url =BaseURL;
        driver.get(url);

        actions = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }
    @AfterMethod
    static void closeBrowser(){
        driver.quit();
    }
    @DataProvider(name="IncorrectLoginProviders")
    public static Object [][] getDataFromDataProviders(){
        return new Object[][] {
                {"NotExistingEmail@mail.com", "NotExistingPassword"},
                {"yuliyakis85@gmail.com", " "},
                {" ", " "},
        };
    }
}
