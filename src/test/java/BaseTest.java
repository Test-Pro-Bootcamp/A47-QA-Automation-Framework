import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String url;
    public static Actions action;

    /*BasePage basePage = new BasePage(driver);
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    SongsPage songsPage  = new SongsPage(driver); */



    /* this isnt needed with our pick browser method
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager is the automation of driver management.
        //To use it, we need to select a given manager in the WebDriverManager API
        //e.g., chromedriver(), firefoxdriver() and invoke the method setup()
    } */

    //adding this method for dynamic browser selection
    public static WebDriver pickBrowser(String browser) {
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("start-maximized");
                return driver = new EdgeDriver(edgeOptions);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("start-maximized");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
//      Added ChromeOptions argument below to fix websocket error
        //dont need this here now, with the pick browser method
        // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*"); //allows redirection from http to https
        //options.addArguments("start-maximized");
        //or driver.manage().window().maximize();
        //driver = new ChromeDriver(options); selenium grid will use dynamic input values for browser
        driver = pickBrowser(System.getProperty("browser"));
        //implicit wait is not the best. use explicit wait instead
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getIncorrectDataFromDataProviders() {
        return new Object[][] {
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }
    @DataProvider(name="CorrectLoginProviders")
    public static Object[][] getCorrectDataFromDataProviders() {
        return new Object[][] {
                {"demo@class.com", "te$t$tudent"},
                /*{"chelsea.laurenson@testpro.io", "te$t$tudent"}  this is not logging me in? */
        };
    }

    //Searching songs helper methods
    protected void searchForASong(String songName) {
        //class example that worked was "div#searchForm input[type=search]"
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'search']")));
        searchField.click();
        searchField.sendKeys(songName);
    }
    protected void clickViewAllButton() throws InterruptedException{
        //failed selectors "button[data-test = 'view-all-songs-btn']"
        //.song>button
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
        viewAllButton.click();
        //Thread.sleep(20000);
    }
    protected void selectFirstSongResult() {
        //failed "[.song-title>td.title]"
        //"#songResultsWrapper > div > div > div.resize-observer"
        //"#songResultsWrapper > div > div > div.item-container > table > tr"
        //"#songResultsWrapper > div > div > div.item-container > table > tr.song-item")
        //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"
        //"#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title")
        WebElement firstSongInList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article:nth-child(1) > span.main > span.details")));
        firstSongInList.click();
        //Thread.sleep(20000);

        }
        protected void clickAddToButton() throws InterruptedException {
        //failed ".btn-add-to")
            // HW feedback but still fail "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"
            //#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to
            WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
            addToButton.click();
            //Thread.sleep(20000);
    }

    protected void choosePlayList() throws InterruptedException {
        //failed ".playlist>li")
        //HW feedback to try "//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"
        WebElement playListFromDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        //Thread.sleep(20000);
        playListFromDropDown.click();
    }
    protected String getSongAddedToPlaylistNotificationText() {
        // "div.success.show"
        WebElement addedToPlaylistNotification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return addedToPlaylistNotification.getText();
    }

    //playing songs helper methods
     protected void playNextSong() throws InterruptedException {
        WebElement nextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.next.fa.fa-step-forward.control")));

        action.moveToElement(nextSongButton).perform();
        nextSongButton.click();
        nextSongButton.click();
        //Thread.sleep(20000);
        }

        //playlist actions helper methods
        protected void selectAPlaylist() {
        WebElement playListFromSideBar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(5)")));
        playListFromSideBar.click();
    }

    protected void doubleClickAPlaylist() {
        action = new Actions(driver);
        WebElement playListFromSideBar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(5)")));
        action.doubleClick(playListFromSideBar);
    }


    protected void deleteSelectedPlayList() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deleteButton.click();
    }

    protected void managePopUpWindow() {

        try {
            WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
            confirm.click();
        } catch(Exception e) {

        }
    }
    protected String getSongDeletedFromPlaylistNotification() {
        WebElement deletedFromPlaylistNotification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return deletedFromPlaylistNotification.getText();
    }

    //count songs helper methods
    protected void choosePlaylistByName(String playlistName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size() ;
    }

    protected String getPlaylistDetails() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.meta.text-secondary span.meta"))).getText();
    }

    protected void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs Found:" + countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    //rename playlist helper methods
    String newPlayListName = "re-named";
    protected void enterNewPlayListName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']]")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    protected String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");

    }

    public boolean doesPlayListExist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlayListName + "']")));
        return playListElement.isDisplayed();
    }






}




