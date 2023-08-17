import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);

    }

    //public static void openLoginUrl(){
      //  String url = "https://qa.koel.app/";
      //  driver.get(url);
   // }

    public static void enterEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

    }

    public static void enterPassword(String password){
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public static void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void clickPLayList(){
        WebElement selectPlayList = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        selectPlayList.click();

    }

    public void clickDeletePlayList() throws InterruptedException {
        WebElement deletePlayList = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button"));
        deletePlayList.click();
        Thread.sleep(2000);
    }

    public String getNotificationDelete(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }


}