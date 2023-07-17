import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void lunchBrowser() {

        //      Added ChromeOptions argument below to fix websocket error

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    //Helper functions
    public static void searchSong(String songTileKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector(("div#searchForm input[type=search]")));

        searchField.clear();
        searchField.sendKeys(songTileKeyword);
        Thread.sleep( 5000);




        }

    public static void clickViewAllBtn() throws InterruptedException {
    WebElement viewAllSearchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
    viewAllSearchResult.click();
    Thread.sleep( 5000);
    }
    public static void selectFirstSong() throws InterruptedException{
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        firstSongResult.click();
        Thread.sleep(5000);
    }
    public static void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(5000);
    }

    public static void choosePlayList() throws InterruptedException{
        WebElement playList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playList.click();
        Thread.sleep(5000);
    }

    public static String getNotificationText() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
            return    notificationText.getText();
    }

    public static void enterEmail(String email){
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public static void clickSubmit(){
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }

}

