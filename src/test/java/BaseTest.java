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
    public void selectDeletePlaylist (String Playlist) {
        selectPlaylist (Playlist);
        deletePlaylist ();
    }
    public void selectPlaylist (String Playlist){
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
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//section[@id='playlists']//li[@class='playlist playlist'] /a")));
        actions.doubleClick(choosePlaylistElement).perform();
        System.out.println("Playlist " + Playlist + " is clicked");
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
    public String doesPlaylistExists(){
        WebElement playListElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("div.success.show")));
        return playListElement.getText();
    }
}