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
import java.util.UUID;

public class BsTest {
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
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

    protected static void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    protected static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected static void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    // Profile Tests Helper Functions
    protected static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    protected static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
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

    protected static void ClickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(("button.btn-submit")));
        saveButton.click();
    }

    protected static void searchSong(String song) {
        WebElement songSearch = driver.findElement(By.cssSelector("[type='search']"));
        songSearch.click();
        songSearch.clear();
        songSearch.sendKeys(song);
    }

    protected static void clickViewAll() {
        WebElement viewAll = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAll.click();
    }

    protected static void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
    }

    protected static void clickAddTo() {
        WebElement clickAdd = driver.findElement(By.cssSelector("button.btn-add-to"));
        clickAdd.click();
    }
    protected static void addToPlaylist() {
        WebElement addPlaylist = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(),'TestPro')]"));
        addPlaylist.click();
    }
    public static String getNotification(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }
}
