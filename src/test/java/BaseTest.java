import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest{
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static Actions actions = null;



    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
   public void launchBrowser(String BaseURL){


       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);//added
        url = BaseURL;
        driver.get(url);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
//        driver.get(url); //commented, driver.get() will be in @BeforeMethod
    }


    public static void navigateToPage(){
        driver.get(url);
    }
    public static void provideEmail(String email){
        WebElement emailField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
      //  WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
       // WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    public void searchSong(String songTitleKeyword)  {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type = search]")));
        searchField.clear();
        searchField.sendKeys(songTitleKeyword);

    }
    public void  clickViewAllBtn()  {
        WebElement viewAllSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']")));
        viewAllSearchResult.click();
    }
    public void selectFirstSongResult() {
        WebElement firstSongResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class='songs'] span[class='details']")));
        firstSongResult.click();
    }
    public void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//button[contains(text(),'Add To…')]")));
        addToBtn.click();
    }
    public void choosePlayList() {
        WebElement playListElement = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] li[class='favorites']"));
        playListElement.click();
    }
    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationElement.getText();
    }
    public void clickPlay(){
        WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[1]//i[2]")));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]")));

        playButton.click();
        playNextButton.click();
    }
    public Boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div")));
        return soundBar.isDisplayed();
    }
    public void openPlaylist(){
      //  WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='playlist playlist']")));
        playlist.click();
    }

    public void clickDeletePlaylistBtn(){
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }
    public void confirmDelete()  {
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='Delete']")));
       // WebElement confirmBtn = driver.findElement(By.cssSelector("button.ok"));
        confirmBtn.click();

    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

}