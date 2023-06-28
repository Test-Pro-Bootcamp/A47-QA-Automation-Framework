import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver= null;
    String url = "https://qa.koel.app/";
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");
    By submitButton = By.cssSelector("[type = 'submit']");
    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    By choosePlaylist =
            By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Beta')]");
    By notification = By.cssSelector("div.success.show");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDownBrowser (){
        driver.quit();
    }
    public void openLoginURL() {
        driver.get(url);
    }
    public void provideEmail (String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void providePW (String password) {
        WebElement pwField = driver.findElement(passwordField);
        pwField.sendKeys(password);
    }
    public void clickSubmit () throws InterruptedException {
        WebElement subButton = driver.findElement(submitButton);
        subButton.click();
        Thread.sleep(2000);
    }
    public void searchSong (String songText) throws InterruptedException {
        WebElement searchElement = driver.findElement(searchField);
        searchElement.click();
        searchElement.clear();
        searchElement.sendKeys(songText);
        Thread.sleep(1000);
    }
    public void clickViewAllButton () throws InterruptedException {
        WebElement viewAllElement = driver.findElement(viewAllButton);
        viewAllElement.click();
        Thread.sleep(1000);
    }
    public void clickFirstSong () throws InterruptedException {
        WebElement clickSong = driver.findElement(selectSong);
        clickSong.click();
        Thread.sleep(1000);
    }
    public void clickAddToButton () throws InterruptedException {
        WebElement addToElement = driver.findElement(addToButton);
        addToElement.click();
        Thread.sleep(1000);
    }
    public void clickPlaylist () throws InterruptedException {
        WebElement choosePlaylistElement = driver.findElement(choosePlaylist);
        choosePlaylistElement.click();
        Thread.sleep(1000);
    }
    public String getNotification (){
        WebElement notificationMessage = driver.findElement(notification);
        return notificationMessage.getText();
    }
// Delete the song added in Playlist "Beta", to avoid failing while re-running the code.
// (Same song cannot be added the second time causing it to fail.)
    public void selectPlaylist (String Playlist)  {
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = driver.findElement(By.xpath(selectedPlaylistLocator));
        selectedPlaylistElement.click();
        System.out.println("Playlist Selected");
    }
   public void deleteFirstSongInPlaylist ()  {
       String selectFirstSong= "section#playlistWrapper table.items td.title";
       WebElement selectSongElement = driver.findElement(By.cssSelector(selectFirstSong));
       selectSongElement.click();
       System.out.println("Song Selected");
       Actions action = new Actions(driver);
       action.sendKeys(Keys.DELETE).build().perform();
       //selectSongElement.sendKeys(Keys.DELETE);
       System.out.println("Song deleted");
     }
    }
