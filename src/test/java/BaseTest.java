import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    //login locators
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
    // delete playlist locators
    By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");
    //create playlist locators
    By plusIconLocator = By.cssSelector("i.fa.fa-plus-circle.create");
    By newSimplePlaylistLocator = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistNameFieldLocator = By.cssSelector("input[name='name']");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications","--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
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
    public void login(String email, String password) {
        //enter email address
        WebElement emailElement = 	wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailElement.clear();
        emailElement.sendKeys(email);
        //enter password
        WebElement pwField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        pwField.clear();
        pwField.sendKeys(password);
        //click submit button
        WebElement subButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        subButton.click();
    }
    // Create Playlist
    public void createPlaylist (String Playlist){
        WebElement plusIconElement =wait.until(ExpectedConditions.elementToBeClickable(plusIconLocator));
        plusIconElement.click();

        WebElement newSimplePlaylistMenuElement =wait.until(ExpectedConditions.elementToBeClickable(newSimplePlaylistLocator));
        newSimplePlaylistMenuElement.click();

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

    public void deleteSelectedPlaylist (String Playlist)  {
        // select playlist
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                                                                            (By.xpath(selectedPlaylistLocator)));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist+ " has been selected");
        // delete playlist
        WebElement deletePlaylistBtnElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtnLocator));
        deletePlaylistBtnElement.click();
        }
        public String deletedPlaylistNotify() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteNotifyLocator));
        String notifyText = notificationElement.getText();
        System.out.println("Message is: " + notifyText);
        return notifyText;
    }
        public boolean avatarIsDisplayed(){
        WebElement avatarElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
        return avatarElement.isDisplayed();
        }
}