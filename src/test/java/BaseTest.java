import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.Keys;

import javax.swing.*;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

//    private WebDriver driver = null;

    public static String url = "https://qa.koel.app/";

    public static WebDriverWait wait = null;

    public static Actions actions = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    @BeforeSuite
//    public static void chromeConfigs() {
//
//        if (System.getProperty("os.name").toLowerCase().contains("ios")) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver");
//        }
//    }
//    static void setupClass() {
//
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.FirefoxDriver().setup();
//
//
////    }


    @BeforeMethod
    @Parameters ({"baseUrl"})
    public void lunchBrowser(@Optional String baseUrl) throws MalformedURLException {

        //      Added ChromeOptions argument below to fix websocket error

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new FirefoxDriver();
//        driver = pickBrowser("grid-firefox");
//        driver = new ChromeDriver(options);
        threadDriver.set(pickBrowser(System.getProperty("browserName")));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;
        getDriver().get(baseUrl);


        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        actions = new Actions(getDriver());
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver (){
        return threadDriver.get();
    }

    public void openLoginUrl() {
        String url = "https://qa.koel.app/";
        getDriver().get(url);
    }



    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.0.0.67:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }


    //Helper functions
    public void searchSong(String songTileKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector(("div#searchForm input[type=search]")));

        searchField.clear();
        searchField.sendKeys(songTileKeyword);
        Thread.sleep( 5000);




        }

    public void clickViewAllBtn() throws InterruptedException {
    WebElement viewAllSearchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
    viewAllSearchResult.click();
    Thread.sleep( 5000);
    }
    public void selectFirstSong() throws InterruptedException{
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        firstSongResult.click();
        Thread.sleep(5000);
    }
    public void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(5000);
    }

    public void choosePlayList() throws InterruptedException{
        WebElement playList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playList.click();
        Thread.sleep(5000);
    }

    public  String getNotificationText() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
            return    notificationText.getText();
    }

    public static void enterEmail(String email){
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'email']")));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'password']")));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public static void clickSubmit(){
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));
        submitBtn.click();
    }

    public void clickPlayNext(){
        WebElement playNextBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextBtn.click();
    }

    public void clickPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
        playBtn.click();
    }

    public Boolean isSongPlay() {
        WebElement soundBar = driver.findElement(By.cssSelector("div.bars"));
        return soundBar.isDisplayed();
    }

    public static void openPlaylist () throws InterruptedException {
        WebElement accessPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/65568']")));
        accessPlaylist.click();
    }
    public static void deleteItem () throws InterruptedException{
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del")));
        item.click();
    }
    public static void deleteBtn () throws InterruptedException {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        btn.click();
    }

    public String getDeleteMsg() {
        WebElement deleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deleteMsg.getText();
    }

    public static void openOption () throws InterruptedException{
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/65758']")));
        actions.contextClick(option).perform();
    }

    public static void clickEdit () throws InterruptedException{
        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")));
        edit.click();
    }

    public static void rename(String playlistName) {
        WebElement naming = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        naming.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        naming.sendKeys(playlistName);
        naming.sendKeys(Keys.RETURN);
    }




}

