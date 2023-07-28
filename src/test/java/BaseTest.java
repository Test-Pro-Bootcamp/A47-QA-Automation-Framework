import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {

        //WebDriverManager.chromedriver().setup();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.120:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();

            case "MSEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();

            case "grid-firefox":
                caps.setCapability("browser", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-edge":
                caps.setCapability("browser", "MSEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                return driver = new ChromeDriver(options);
        }

    }
    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        driver = pickBrowser(System.getProperty("browser"));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        waitForLoadingScreenToDisappear();

    }
    @AfterMethod
    public void logout() {

        driver.quit();
    }
    @DataProvider (name="CorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"matt.pierce@testpro.io", "te$t$tudent1"}
        };
    }

    public void waitForLoadingScreenToDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));
    }




}