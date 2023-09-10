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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected String url;

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.254:4444/";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(eOptions);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(cOptions);
        }
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    protected void initializeBrowser(String baseUrl) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
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