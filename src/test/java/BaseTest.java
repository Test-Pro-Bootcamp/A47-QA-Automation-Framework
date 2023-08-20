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
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";

    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({ "BaseURL" })
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @DataProvider (name = "CorrectLoginProviders")
    public static Object [][] getLoginData(){
        return new Object[][] {
                { "aimee.woodside@testpro.io", "te$t$tudent13" }
        };
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
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

    public void clickLogInbutton() {
        WebElement LogInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        LogInButton.click();
    }

    // Profile Tests Helper Functions
    protected static void displayAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.isDisplayed();
    }

    public void searchSong(String songTitleKeyword) {
        WebElement searchSongInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchSongInput.click();
        searchSongInput.clear();
        searchSongInput.sendKeys(songTitleKeyword);
    }

    public void clickViewAllSearchBtn() {
        WebElement ViewAllSearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
        ViewAllSearchButton.click();
    }

    public void clickFirstSongSearchResult() {
        WebElement FirstSongSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr")));
        FirstSongSearchResult.click();
    }

    public void clickAddToBtn() {
        WebElement AddToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")));
        AddToButton.click();
    }

    public void selectPlayList(){
        WebElement selectedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        selectedPlaylist.click();
    }

    public String getNotificationMessage() {
        WebElement notificationAlert = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationAlert.getText();
    }
    public void songPlay() {
        WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[1]/i[2]")));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]")));
        playNextButton.click();
        playButton.click();
    }

    public Boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div")));
        return soundBar.isDisplayed();
    }
    // Helper functions for delete playlist
        public void openPlayList(){
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void deletePlaylistBtn(){
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }
    public String getNotificationMsg()    {
        WebElement NotificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return NotificationMsg.getText();
    }

    public void rightclickPlaylist() {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.contextClick(playList).perform();
    }

    public void clickEditOnPlaylist() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)"))).click();
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
    }
}