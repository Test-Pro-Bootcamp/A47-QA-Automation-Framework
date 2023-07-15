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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.Keys;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;
import java.util.List;
public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public static Actions actions = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.firefoxdriver().setup();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.0.53:4444";

        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge"://gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "grid-firefox"://gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "grid-chrome"://gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        //
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
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
        WebElement validateSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter > div.media-info-wrap > div.other-controls > div > button:nth-child(2) > div")));
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

    public void doubleClickPlaylist(){
        WebElement playListElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3")));
        actions.doubleClick(playListElement).perform();
    }
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void  contextClickFirstSong(){
        WebElement firstSongElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public WebElement hoverPlay(){
        WebElement play =  driver.findElement(By.cssSelector("[data-testid = 'play-btn']"));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid = 'play-btn']"));
    }
    // Count Songs Helper Functions
    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWarpper td.title")).size();
    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs Found:" + countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }

    }
    String newPlaylistName = "new name";
    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlaylistName + "' ]")));
        return playlistElement.isDisplayed();
    }

}
