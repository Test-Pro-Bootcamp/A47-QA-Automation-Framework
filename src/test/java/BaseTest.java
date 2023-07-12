import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

        public static WebDriver driver = null;
        public static String url = "https://qa.koel.app/";

        @BeforeSuite
        static void setupClass() {WebDriverManager.chromedriver().setup();
        }

        @BeforeMethod
        @Parameters({ "BaseURL" })
        public void launchBrowser(String BaseURL) {
            // Added ChromeOptions argument below to fix websocket error
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            url = BaseURL;
            driver.get(url);
        }

        @AfterMethod
        public void closeBrowser() {
            driver.quit();
        }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    protected static void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    protected static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

        protected static void clickSubmit() {
            WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
            submitLogin.click();
        }

    // Helper functions for the Homework task
        public void searchSong(String songTitleKeyword) throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector(("div#searchForm input[type=search]")));
            searchField.clear();
            searchField.sendKeys(songTitleKeyword);
            Thread.sleep(5000);
        }

        public void clickViewAllBtn() throws InterruptedException {
            WebElement viewAllSearchResult = driver
                    .findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
            viewAllSearchResult.click();
            Thread.sleep(5000);
        }

        public void selectFirstSongResult() throws InterruptedException {
            WebElement firstSongResult = driver
                    .findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
            firstSongResult.click();
            Thread.sleep(5000);
        }

        public void clickAddToBtn() throws InterruptedException {
            WebElement addToBtn = driver.findElement(
                    By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
            addToBtn.click();
            Thread.sleep(5000);
        }

        public void choosePlayList() throws InterruptedException {
            WebElement playListElement = driver
                    .findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[74]"));
            playListElement.click();
        }

        public String getNotificationText() {
            WebElement notificationElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
            return notificationElement.getText();
        }

        // Methods for Playing Songs
        public void clickPlay() {
            WebElement playNextButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
            WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]"));

            playNextButton.click();
            playButton.click();
        }

        public Boolean isSongPlaying() {
            WebElement soundBar = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div"));
            return soundBar.isDisplayed();
        }

    }