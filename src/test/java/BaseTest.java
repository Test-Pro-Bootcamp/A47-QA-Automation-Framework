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
import java.net.URL;
import java.util.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "https://qa.koel.app/";

    public static ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    static void setupClass() {

        //WebDriverManager.chromedriver().setup();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.120:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MSEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-edge":
                caps.setCapability("browserName", "MSEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "lambda":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                return driver = new ChromeDriver(options);
        }
    }

    public WebDriver lambdaTest () throws MalformedURLException {
        String username = "matt.pierce";
        String accessToken = "YacQSQmppqysHGB83sjdP50DWd7doiKrFyYzXC439KpSBuCYBc";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessToken);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        actions = new Actions(getDriver());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = BaseURL;
        getDriver().get(url);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        waitForLoadingScreenToDisappear();

    }

    @AfterMethod
    public void logout() {

        getDriver().quit();
        threadDriver.remove();
    }

    @DataProvider(name = "CorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"matt.pierce@testpro.io", "te$t$tudent1"}
        };
    }

    public void waitForLoadingScreenToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

}