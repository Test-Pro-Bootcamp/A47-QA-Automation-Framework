import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    //login locators
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
    // delete playlist locators
    By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications","--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseURL;
        driver.get(url);
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    public void login(String email, String password) {
        //enter email address
        WebElement emailElement = 	wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailElement.clear();
        emailElement.sendKeys(email);
        //enter password
        WebElement pwField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        pwField.clear();
        pwField.sendKeys(password);
        //click submit button
        WebElement subButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        subButton.click();
    }
    public void deleteSelectedPlaylist (String Playlist)  {
        // select playlist
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                                                                            (By.xpath(selectedPlaylistLocator)));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist+ " has been selected");
        // delete playlist
        WebElement deletePlaylistBtnElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtnLocator));
        deletePlaylistBtnElement.click();
    }
        public String deletedPlaylistNotify() {
        WebElement notificationElement = wait.until(ExpectedConditions.presenceOfElementLocated(deleteNotifyLocator));
        String notifyText = notificationElement.getText();
        System.out.println("Message is: " + notifyText);
        return notifyText;
    }
}