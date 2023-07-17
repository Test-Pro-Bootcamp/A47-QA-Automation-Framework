import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
//import java.util.;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
    By overlayLocator = By.cssSelector(".overlay.loading");
    //locators: Create a new playlist
    By plusIconLocator = By.cssSelector("i.fa.fa-plus-circle.create");
    By newSimplePlaylistLocator = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistNameFieldLocator = By.cssSelector("input[name='name']");
    // Locators: Delete an existing Playlist
    By deletePlaylistBtnLocator = By.cssSelector("button[title='Delete this playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");
    // is song playing locators
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By pauseButton = By.cssSelector("span.pause");
    // By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");
    //play control- play button
    By PlayControlBtn = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//        driver.manage().window().maximize();
//        Is same as:
//        options.addArguments("--start-maximized");
        actions = new Actions(driver);
        url = baseURL;
        driver.get(url);
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    // Login
    //-------------------------
    public void provideEmail(String email) {
        WebElement emailFieldElement = wait.until(ExpectedConditions.elementToBeClickable
                (emailFieldLocator));
        emailFieldElement.clear();
        emailFieldElement.sendKeys(email);
    }
    public void providePW(String password) {
        WebElement pwFieldElement = wait.until(ExpectedConditions.elementToBeClickable
                (passwordFieldLocator));
        pwFieldElement.clear();
        pwFieldElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement subButtonElement = wait.until(ExpectedConditions.elementToBeClickable
                (submitButtonLocator));
        subButtonElement.click();
    }
    public void login(String email, String password) {
        provideEmail(email);
        providePW(password);
        clickSubmit();
    }
    public void waitForOverlayToVanish(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }
    //Create a new playlist
    //-------------------------
    public void createNewPlaylist (String Playlist) throws InterruptedException{
        waitForOverlayToVanish();
        WebElement plusIconElement =wait.until(ExpectedConditions.presenceOfElementLocated(plusIconLocator));
        Thread.sleep(2000);
        plusIconElement.click();
        //
        WebElement newSimplePlaylistMenuElement =wait.until(ExpectedConditions.elementToBeClickable(newSimplePlaylistLocator));
        newSimplePlaylistMenuElement.click();
        //
        WebElement playlistNameField =wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNameFieldLocator));
        playlistNameField.sendKeys(Playlist);
        playlistNameField.sendKeys(Keys.ENTER);
        System.out.println("Playlist " +Playlist+ " is created");
    }
    public String newPlaylistNotification(){
        WebElement newPlaylistMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='alertify-logs top right']//div[@class='success show']")));
        String NewMsgText= newPlaylistMsg.getText();
        System.out.println("Msg Notification: " + NewMsgText);
        return NewMsgText;
    }
    public boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[@class='playlist playlist']//a[@class='active']")));
        boolean isDisplayed = newPlaylist.isDisplayed();
        System.out.println("Playlist is displayed = "+ isDisplayed );
        return isDisplayed;
    }
    // Delete Playlist
    //-------------------------
    public void selectDeletePlaylist (String newPlaylistName) {
        selectPlaylistByName (newPlaylistName);
        deletePlaylist ();
    }
    public void selectPlaylistByName (String Playlist){
        waitForOverlayToVanish();
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(selectedPlaylistLocator)));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist+ " has been selected");
    }
    public void deletePlaylist (){
        waitForOverlayToVanish();
        WebElement deletePlaylistBtnElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtnLocator));
        deletePlaylistBtnElement.click();
        System.out.println("Playlist has been deleted");
    }
    public String deletedPlaylistNotify() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteNotifyLocator));
        String notifyText = notificationElement.getText();
        System.out.println("Message is: " + notifyText);
        return notifyText;
    }
// Rename Playlist
//-------------------------
        public void doubleClickPlaylist (String Playlist) {
        waitForOverlayToVanish();
//        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
//                  (By.xpath("//section[@id='playlists']//li[@class='playlist playlist'] /a")));
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(choosePlaylistElement).perform();
        System.out.println("Playlist " + Playlist + " is double clicked");
    }

    public void contextClickPlaylist (String Playlist){
        waitForOverlayToVanish();
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(".playlist:nth-child(3)")));
      // By playlistElementLocator= By.xpath("//section[@id='playlists']//li[@class='playlist playlist'] /a");

        actions.contextClick(choosePlaylistElement).perform();
        System.out.println("Playlist " + Playlist + " is right/context clicked");
    }
    public void clickEditMenu (){
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
    // (By.cssSelector("nav.menu.playlist-item-menu li[data-testid='playlist-context-menu-edit-63429']")));
    //  (By.xpath("//nav[@class='menu playlist-item-menu']//li[data-testid='playlist-context-menu-edit-63429']")));
      (By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")));
        choosePlaylistElement.click();
        System.out.println("Edit is clicked");
    }

    public void enterNewPlaylistName (String newPlaylistName) {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        playListInputField.sendKeys(Keys.DELETE);
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
        System.out.println("New playlist name " + newPlaylistName + " is entered");
    }
//    public String playlistNameChangeNotify(){
//        WebElement playListElement = wait.until(ExpectedConditions.presenceOfElementLocated
//                (By.cssSelector("div.success.show")));
//        return playListElement.getText();
//    }
    public boolean doesPlaylistExist(String NewPlaylistName){
        WebElement playListElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//a[text()='" + NewPlaylistName + "']" )));
        return playListElement.isDisplayed();
    }

// Play song using context click
    public void chooseAllSongsList() {
        waitForOverlayToVanish();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }
    public void choosePlayOption() {
        WebElement playOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playback")));
        actions.click(playOptionElement).perform();
    }
    public boolean isSongPlaying() {
         WebElement soundBarVisualizerBarElement = wait.until(ExpectedConditions.presenceOfElementLocated
            (soundBarVisualizer));
        return soundBarVisualizerBarElement.isDisplayed();
    }
    public void hoverOverPlayControl(){
        waitForOverlayToVanish();
        WebElement hoverOverPlayBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(PlayControlBtn));
        actions.moveToElement(hoverOverPlayBtnElement).perform();
        System.out.println("Hovered Over Play Control");
    }
    public WebElement isPlayHoveredOver(){
        WebElement PlayBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PlayControlBtn));
        System.out.println("Play Control is visible");
        return PlayBtnElement;
    }
}