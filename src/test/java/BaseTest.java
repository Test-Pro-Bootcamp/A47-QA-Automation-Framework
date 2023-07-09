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
    public void closeBrowser(){
    driver.quit();
    }
    protected static void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    protected static void enterPassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
    }

    protected static void enterEmail() {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("dulcealergica@yahoo.com");
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    protected static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    protected static void providePassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    protected static void provideProfileName(String name) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(name);
    }
    protected static void  ClickSaveButton () {
        WebElement saveButton = driver.findElement(By.cssSelector(("button.btn-submit")));
        saveButton.click();
    }
        public void searchSongInput() throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
            searchField.clear();
            searchField.sendKeys("Dark Days");
            Thread.sleep(5000);
        }
        public void clickViewAllBtn() throws InterruptedException {
                WebElement viewAllSearchResult = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
                viewAllSearchResult.click();
                Thread.sleep(5000);
            }
            public void selectFirstSongResult() throws InterruptedException {
                   WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
                   firstSongResult.click();
                   Thread.sleep(5000);
            }
            public void clickAddToBtn() throws InterruptedException {
                    WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
                    addToBtn.click();
                    Thread.sleep(5000);
                }
            public void choosePlaylist() throws InterruptedException {
                    WebElement playListElement = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
                     playListElement.click();
    }
            public String getNotificationText () {
                    WebElement notificationElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
                    return notificationElement.getText();
                }
            }





