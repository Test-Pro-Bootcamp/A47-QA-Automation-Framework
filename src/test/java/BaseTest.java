import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
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
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    String url;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.254:4444/";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(eOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(cOptions);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("111.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "daviyontae.floyd");
        ltOptions.put("accessKey", "pkhma9IsnRQiTj7iyCg61dxihV4lMnhjvogRSf02ghI04rd8NL");
        ltOptions.put("video", true);
        ltOptions.put("build", "Edge");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }

    public void navigateToPage(){
        threadDriver.get().get(url);
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    protected void initializeBrowser(String baseUrl) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = baseUrl;
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        actions = new Actions(getDriver());
        navigateToPage();
    }


    @AfterMethod
    protected void quitBrowser(){
//        Quit browser
        getDriver().quit();
        threadDriver.get().quit();
        threadDriver.remove();
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