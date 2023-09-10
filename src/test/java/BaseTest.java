import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait=null;
    public static Actions actions = null;

    public static ThreadLocal<WebDriver> threaddriver=new ThreadLocal<>();


    public static String url="https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
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








