import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.security.Key;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        url = BaseURL;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

//    public static void navigateToPage() {
//        driver.get(url);
//    }
//
//    public static void provideEmail(String email) {
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'email']")));
//        emailField.click();
//        emailField.clear();
//    }
//
//    public static void providePassword(String password) {
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'password'")));
//        passwordField.click();
//        passwordField.clear();
//    }
//
//    public static void clickSubmit() {
//        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type = 'submit']")));
//    }
//    public static void playASong() {
//        WebElement playNextSongBtn = driver.findElement(By.className("next"));
//        WebElement playSongBtn = driver.findElement(By.xpath("//span[@data-testid = 'play-btn']"));
//        playNextSongBtn.click();
//        playSongBtn.click();
//    }
//
//    public boolean soundBarIsDisplayed() {
//        WebElement soundBar = driver.findElement(By.className("bars"));
//        return soundBar.isDisplayed();
//    }
//    public boolean pauseBtnIsDisplayed() {
//        WebElement pauseBtn = driver.findElement(By.className("pause"));
//        return pauseBtn.isDisplayed();
//    }
//    public static void openPlaylist() {
//        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist'][1]")));
//        clickPlaylist.click();
//    }
//    public static void deletePlaylistBtn() throws InterruptedException {
//        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del")));
//        clickDelete.click();
//    }
//    public String getDeleteMsg() {
//        WebElement deleteMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.success.show")));
//        return deleteMsg.getText();
//    }
//    public static void doubleClickPlaylist() {
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist'][1]")));
//        actions.doubleClick(playlist).perform();
//    }
//    public static String playlistName = "testHomework21";
//    public static void newPlaylistName() {
//        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name= 'name']")));
//        nameField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
//        nameField.sendKeys(playlistName);
//        nameField.sendKeys(Keys.ENTER);
//    }
//    public boolean playlistIsDisplayed() {
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = '"+playlistName+"']")));
//        return playlist.isDisplayed();
//    }
}