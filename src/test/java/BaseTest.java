import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
<<<<<<< Updated upstream

=======
import org.testng.annotations.Parameters;
>>>>>>> Stashed changes
import java.time.Duration;



public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
        Actions actions = new Actions(driver);
    }

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url=BaseUrl;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }

    public static void navigateToPage(){
        driver.get(url);

    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

public static void providePassword(String password){
       WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
       passwordField.click();
       passwordField.clear();
       passwordField.sendKeys(password);
    }

    public static void clickSubmit(){
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}