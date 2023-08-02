import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    @DataProvider(name = "regressionTests")
    protected static Object[][] getDataFromDataProvider() {
        return new Object[][]{{"invalid@invalid.com", "school!sc0"},
                {"angel.ayala@testpro.io", "wrongPassword"},{"angel.ayala@testpro.io", ""},{"","school!sc0"},
                {"",""},};
    }
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String url;
    protected static final ThreadLocal <WebDriver> threadDriver = new ThreadLocal<>();
    public WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.75:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions foxOptions = new FirefoxOptions();
                foxOptions.addArguments("--disable-notifications");
                return driver = new FirefoxDriver(foxOptions);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
               // chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                return driver = new ChromeDriver(chromeOptions);
        }

    }
    public WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "raptfuneral");
        ltOptions.put("accessKey", "Cqm43VTgVsKAkKQRXB1GZglMhoM54JShOwOvyZCpaBUvXX1p8o");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return driver = new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    public WebDriver getDriver(){
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters("BaseURL")
    public void launchBrowser(String BaseURL) throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser(){
        getDriver().close();
        threadDriver.remove();
    }
}
