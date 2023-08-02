import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.lang.reflect.MalformedParametersException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.net.URI;


public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait=null;
    public static Actions actions = null;

    public static ThreadLocal<WebDriver> threaddriver=new ThreadLocal<>();


    public static String url="https://qa.koel.app/";

//    @BeforeSuite
 //   static void setupClass() {
  //      WebDriverManager.chromedriver().setup();
  //  }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "alexpanov.business");
        ltOptions.put("accessKey", "2wzy1GSF5MKMA7iL3Sdgp7KyBYbpklgevAqinNSyZLkyBuda2O");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser() throws MalformedURLException{
       threaddriver.set(pickBrowser(System.getProperty("browser")));
       wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
       actions = new Actions(getDriver());
       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       navigateToPage();

       // driver= pickBrowser(BaseURL);
       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origin =*");
        //driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //url = BaseURL;
       // navigateToPage();
    }
    public static WebDriver getDriver()
    {
      return threaddriver.get();
    }
    public static  WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.9:4444";
        switch (browser)
        {
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
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
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver=new ChromeDriver(chromeOptions);
        }

    }



    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void teardown()
    {
        threaddriver.get().close();
        threaddriver.remove();
    }
    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    @

            DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders()
    {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"}, {"demo@class.com", ""}, {"", ""},};
    }


    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

}








