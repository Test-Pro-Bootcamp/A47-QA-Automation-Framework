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
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    protected static void openLoginUrl() {
        String url = ("https://qa.koel.app/");
        driver.get(url);
    }
    public void enterEmail(String Email) {
        WebElement enterEmail = driver.findElement(By.cssSelector("[type='email']"));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("irene.perdon@testpro.io");
    }
    public void enterPassword(String Password) {
        WebElement enterPassword = driver.findElement(By.cssSelector("[type='password']"));
        enterPassword.click();
        enterPassword.clear();
        enterPassword.sendKeys("te$t$tudent");
    }
    public void clickSubmit(){
        WebElement clickSubmit = driver.findElement(By.cssSelector("[type='submit']"));
        clickSubmit.click();
    }
     public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector(("div#searchForm input[type=search]")));
        searchField.clear();
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(5000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllSearchResult.click();
        Thread.sleep(5000);
        }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement FirstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper tr:nth-child(1) td.title"));
        FirstSongResult.click();
        Thread.sleep(5000);
        }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(5000);
        }
    public void choosePlayList() throws InterruptedException {
        WebElement playListElement = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playListElement.click();
        Thread.sleep(2000);
        }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();

    }
}
