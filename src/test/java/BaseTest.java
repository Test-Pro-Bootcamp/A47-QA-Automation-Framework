import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

//    These aren't working. For now, passing the locators in with the methods.
//    By emailField = By.cssSelector("input[type='email']");
//    By passwordField = By.cssSelector("input[type='password']");
//    By submitBtn = By.cssSelector("button[type ='submit']");



    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
//        Added ChromeOptions argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        url = BaseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
  }
    public void navigateToPage() {
        driver.get(url);

    }
    public void provideEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
//        Passing emailField isn't working, so not using it for now
//        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("emailField")));
//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailElement.clear();
        emailElement.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
//        Passing passWordField isn't working, so not using it for now
//        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("passwordField")));
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
//        Passing submitBtn isn't working.
//        WebElement submit = driver.findElement(By.cssSelector("submitBtn"));
        submit.click();

    }
}