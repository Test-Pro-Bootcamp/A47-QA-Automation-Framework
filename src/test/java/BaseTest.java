import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

    public static WebDriver pickBrowser (String browserName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.12.202:4444";
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver(); // creating an object of FirefoxDriver
            case "MSEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito",
                        "--start-maximized");
                return driver = new EdgeDriver(edgeOptions);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito",
                        "--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }
    @BeforeSuite
    static void setupClass() {
        // WebDriverManager is the automation of driver management.
        // To use it, we need to select a given manager in the WebDriverManager API.
        // (eg., firefoxdriver() for Firefox browser) and invoke the setup() method.
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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