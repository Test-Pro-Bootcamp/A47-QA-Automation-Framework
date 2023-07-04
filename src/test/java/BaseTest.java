import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;
public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "CorrectLoginProviders")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"victor.flores@testpro.io", "te$t$tudent"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }
    protected static void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    protected static void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    protected static void clickSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    //    protected static void openLoginUrl() {
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//    }
    // Profile Tests Helper Functions
    protected static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    protected static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    protected static void providePassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    protected static void provideProfileName(String name) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(name);
    }

    protected static void ClickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(("button.btn-submit")));
        saveButton.click();
    }

    protected static void searchSong(String song) {
        WebElement songSearch = driver.findElement(By.cssSelector("[type='search']"));
        songSearch.click();
        songSearch.clear();
        songSearch.sendKeys(song);
    }

    protected static void clickViewAll() {
        WebElement viewAll = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAll.click();
    }

    protected static void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
    }

    protected static void clickAddTo() {
        WebElement clickAdd = driver.findElement(By.cssSelector("button.btn-add-to"));
        clickAdd.click();
    }

    protected static void addToPlaylist() {
        WebElement addPlaylist = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(),'TestPro')]"));
        addPlaylist.click();
    }

    public static String getNotification() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }

    protected void playNextSong() throws InterruptedException {
        WebElement clickNext = driver.findElement(By.cssSelector(".next.fa"));
        WebElement playSong = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > span > span.play"));

        clickNext.click();
        playSong.click();
    }

    public boolean validateSongPlaying() {
        WebElement validateSong = driver.findElement(By.cssSelector("#mainFooter > div.media-info-wrap > div.other-controls > div > button:nth-child(2) > div"));
        return validateSong.isDisplayed();
    }
    protected static void clickPlaylist() {
        WebElement playListSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        playListSelector.click();
    }
    protected static void clickDeletePlaylist() {
        WebElement playListDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        playListDelete.click();
    }
    public String getDeletedDisplay() {
        WebElement deletedDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletedDisplay.getText();
    }
}
