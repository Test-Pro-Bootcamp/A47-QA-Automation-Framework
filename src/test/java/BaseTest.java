import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;
import java.util.UUID;
public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    // Locators for Login
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
    By overlayLocator = By.cssSelector(".overlay.loading");

    // Locators for Homework 19: Delete an existing Playlist
    By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");

    //locators for create playlist
    By plusIconLocator = By.cssSelector("i.fa.fa-plus-circle.create");
    By newSimplePlaylistLocator = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistNameFieldLocator = By.cssSelector("input[name='name']");

    // Locators for Homework 18: Play Song
    By playNextSongButton = By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    By playSongButton = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");
    By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By progressBarLocator = By.xpath("//progress[@class='plyr__progress--played']");
//    By progressBar = By.xpath(“//input[@type ='range' and @class = 'plyr__progress--seek’]”);
//            XPath for progress bar:  //input[@type ='range' and @class = 'plyr__progress--seek']
//
//    XPath for Play Next Song: //*[@title = 'Play next song' and @data-testid='play-next-btn']
//    XPath for Play button: //*[@title='Play or resume' and  @data-testid='play-btn']
//    XPath for Pause button: //span[@title ='Pause' and @data-testid='pause-btn']
//    CSS Selector for Sound Bar: [data-testid="sound-bar-play"]

    // Locators for Homework 17: Add Song to Playlist
    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    By notification = By.cssSelector("div.success.show");
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
        url = baseURL;
        driver.get(url);
    }
    @DataProvider(name = "CorrectLoginProvider")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"teststudent@teststudent.com", "te$t$tudent"},
        };
    }
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getIncorrectLoginData() {
        return new Object[][]{
                // unregistered email/ correct password
                {"false@testpro.io", "te$t$tudent"},

                // registered email/ Incorrect password
                {"teststudent@teststudent.com", "nonExi$ting"},

                // registered email/ empty password
                {"teststudent@teststudent.com", ""},

                // empty email/ correct password
                {"", "te$t$tudent"},

                // empty email/ empty password
                {"", ""},
        };
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    // Registration Navigation
    //-------------------------
    public void registrationNavigate() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("[id = 'hel']")));
        registrationLink.click();
        System.out.println("Registration link is clicked");
    }
    public boolean registerBtnIsDisplayed(){
        WebElement registerBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='button']")));
        return registerBtnElement.isDisplayed();
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
    public boolean avatarIsDisplayed(){
        WebElement avatarElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
        return avatarElement.isDisplayed();
    }
    public void login(String email, String password) {
        provideEmail(email);
        providePW(password);
        clickSubmit();
    }
    public void waitForOverlayToVanish(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }
    // Create Playlist
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
    // HW19- Delete Playlist
    //-------------------------
    public void selectDeletePlaylist(String Playlist) {
        selectPlaylist (Playlist);
        deletePlaylist ();
    }
        // select playlist
        public void selectPlaylist (String Playlist){
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(selectedPlaylistLocator)));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist+ " has been selected");
    }
        public void deletePlaylist (){
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
// Search song and add to playlist
//--------------------------------
public void searchSong (String songText) {
    WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(searchField));
    searchElement.click();
    searchElement.clear();
    searchElement.sendKeys(songText);
}
    public void clickViewAllButton (){
        WebElement viewAllElement = wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
        viewAllElement.click();
        System.out.println("View All button is clicked ");
    }
    public void clickFirstSong () {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(selectSong));
        clickSong.click();
        System.out.println("First Song is clicked ");
    }
    public void clickAddToButton () {
        WebElement addToElement = wait.until(ExpectedConditions.elementToBeClickable(addToButton));
        addToElement.click();
        System.out.println("Add To button is clicked ");
    }
    public void clickPlaylist (String Playlist) {
        String choosePlaylist =
                "//section[@id='songResultsWrapper']//li[contains(text(), '" + Playlist + "')]";
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(choosePlaylist)));
        choosePlaylistElement.click();
        System.out.println("Playlist " + Playlist + " is clicked");
    }

    public String getNotification (){
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        String Text = notificationMessage.getText();
        System.out.println("Notification Text is: " +Text);
        return Text;
    }
//HW 18: Play a song
//-------------------------
    public void clickPlayNextSong() {
        waitForOverlayToVanish();
        WebElement playNextSongElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (playNextSongButton));
        playNextSongElement.click();
        System.out.println("Play Next Song Button is clicked");
    }
    public void clickPlaySong() {
        WebElement playSongElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (playSongButton));
        playSongElement.click();
        System.out.println("Play Song Button is clicked");
        //    Actions actions = new Actions(driver);
        //    actions.click(playSongElement).perform();
    }
    public boolean pauseButtonDisplay()  {
        WebElement pauseButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (pauseButton));
        boolean PauseDisplaySuccess = pauseButtonElement.isDisplayed();
        System.out.println("Pause Button Displayed = " + PauseDisplaySuccess);
        return PauseDisplaySuccess;
    }
    public boolean soundBarVisualizerDisplay() {
        WebElement soundBarVisualizerBarElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (soundBarVisualizer));
        boolean soundBarVisualDisplaySuccess = soundBarVisualizerBarElement.isDisplayed();
        System.out.println("SoundBar Visualizer Displayed = " + soundBarVisualDisplaySuccess);
        return soundBarVisualDisplaySuccess;
    }
    public boolean progressBarDisplay(){
        WebElement progressBarElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (progressBarLocator));
        boolean progressBarDisplaySuccess = progressBarElement.isDisplayed();
        System.out.println("ProgressBar Displayed = " + progressBarDisplaySuccess);
        return progressBarDisplaySuccess;
    }
    // Delete Song From Playlist
    //--------------------------
    public void deleteSongFromPlaylist() {
        WebElement selectSong = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("div[class='song-list-wrap main-scroll-wrap playlist'] td[class='title']")));
//        selectSong.click();
//        Doesn't work/ why?
//       selectSong.sendKeys(Keys.chord(Keys.DELETE));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectSong).click().sendKeys(Keys.DELETE).perform();
        System.out.println("Song is deleted");
    }
    public String delSongNotificationMsg() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (deleteNotifyLocator));
        String msgText1 = notificationElement.getText();
        System.out.println("Message is: " + msgText1);
        return msgText1;
    }
}