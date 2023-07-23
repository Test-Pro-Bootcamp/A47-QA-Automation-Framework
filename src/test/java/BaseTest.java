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
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver= null;
    public static WebDriverWait wait= null;
    String url = "https://qa.koel.app/";
    // Create a new Playlist locators
    private By plusIconLocator = By.cssSelector("i.fa.fa-plus-circle.create");
    private By newSimplePlaylistLocator = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    private By playlistNameFieldLocator = By.cssSelector("input[name='name']");
    private By newPlaylistMsgLocator = By.xpath
            ("//div[@class='alertify-logs top right']//div[@class='success show']");
    private By newPlaylistLocator = By.xpath("//li[@class='playlist playlist']//a[@class='active']");

// Locators: Delete a Playlist locators
    private By deletePlaylistBtnLocator = By.cssSelector("button[title='Delete this playlist']");
    // By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    private By deleteNotifyLocator = By.cssSelector("div.success.show");
//Login locators
    private By emailField = By.cssSelector("[type = 'email']");
    private By passwordField = By.cssSelector("[type = 'password']");
    private By submitButton = By.cssSelector("[type = 'submit']");
    private By overlayLocator = By.cssSelector(".overlay.loading");
    private By searchField = By.cssSelector("[type='search']");
    private By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    private By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    private By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    private By choosePlaylist =
            By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Beta')]");
    private By notification = By.cssSelector("div.success.show");


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDownBrowser (){
        driver.quit();
    }
    public void openLoginURL() {
        driver.get(url);
    }
    public void provideEmail (String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailElement.sendKeys(email);
    }
    public void providePW (String password) {
        WebElement pwField = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        pwField.sendKeys(password);
    }
    public void clickSubmit () {
        WebElement subButton = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        subButton.click();
    }
    public void login (String email, String password) {
        provideEmail (email);
        providePW (password);
        clickSubmit ();
    }
    public void waitForOverlayToVanish(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }
    //Create new playlist
    //-------------------------
    public void createNewPlaylist(String Playlist) {
        waitForOverlayToVanish();
        WebElement plusIconElement = wait.until(ExpectedConditions.presenceOfElementLocated(plusIconLocator));
        plusIconElement.click();
        //
        WebElement newSimplePlaylistMenuElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (newSimplePlaylistLocator));
        newSimplePlaylistMenuElement.click();
        //
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (playlistNameFieldLocator));
        playlistNameField.sendKeys(Playlist);
        playlistNameField.sendKeys(Keys.ENTER);
        System.out.println("Playlist " + Playlist + " is created");
    }
    public String newPlaylistNotification() {
        WebElement newPlaylistMsg = wait.until(ExpectedConditions.presenceOfElementLocated(newPlaylistMsgLocator));
        String NewMsgText = newPlaylistMsg.getText();
        System.out.println("Msg Notification: " + NewMsgText);
        return NewMsgText;
    }
    public boolean newPlaylistIsDisplayed() {
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(newPlaylistLocator));
        boolean isDisplayed = newPlaylist.isDisplayed();
        System.out.println("Playlist is displayed = " + isDisplayed);
        return isDisplayed;
    }


// Search Song
    public void searchSong (String songText)  {
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        waitForOverlayToVanish();
        searchElement.click();
        searchElement.clear();
        searchElement.sendKeys(songText);
    }
    //Add song to playlist
    public void clickViewAllButton ()  {
        waitForOverlayToVanish();
        WebElement viewAllElement = wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
        viewAllElement.click();
    }
    public void clickFirstSong () {
        waitForOverlayToVanish();
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(selectSong));
        clickSong.click();
    }
    public void clickAddToButton () {
        WebElement addToElement = wait.until(ExpectedConditions.elementToBeClickable(addToButton));
        addToElement.click();
    }
    public void clickPlaylist () {
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(choosePlaylist));
        choosePlaylistElement.click();
    }
    public String getNotification (){
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        return notificationMessage.getText();
    }
// Delete the song added in Playlist "Beta", to avoid failing while re-running the code.
// (Same song cannot be added the second time in the playlist, which causes the test to fail.)
public void selectPlaylistByName(String Playlist) {
    waitForOverlayToVanish();
    String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
    WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
            (By.xpath(selectedPlaylistLocator)));
    selectedPlaylistElement.click();
    System.out.println("Playlist " + Playlist + " has been selected");
}
   public void deleteFirstSongInPlaylist ()  {
       String selectFirstSong= "section#playlistWrapper table.items td.title";
       WebElement selectSongElement = wait.until(ExpectedConditions.elementToBeClickable
               (By.cssSelector(selectFirstSong)));
       selectSongElement.click();
       System.out.println("Song Selected");
       Actions action = new Actions(driver);
       action.sendKeys(Keys.DELETE).build().perform();
       //selectSongElement.sendKeys(Keys.DELETE);
       System.out.println("Song deleted");
     }
    //Delete empty playlist
    //-------------------------
    public void selectDeletePlaylist(String Playlist) {
        selectPlaylistByName(Playlist);
        deletePlaylist();
    }
    public void deletePlaylist() {
        waitForOverlayToVanish();
        WebElement deletePlaylistBtnElement = wait.until(ExpectedConditions.elementToBeClickable
                (deletePlaylistBtnLocator));
        deletePlaylistBtnElement.click();
        System.out.println("Playlist has been deleted");
    }
}
