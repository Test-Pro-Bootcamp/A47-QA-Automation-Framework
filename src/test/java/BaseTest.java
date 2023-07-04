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

public class BaseTest {

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

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public static void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    // Helper functions
    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector(("input[placeholder='Press F to search']")));
        searchField.clear();
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(5000);
    }

    public void  clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        viewAllSearchResult.click();
        Thread.sleep(5000);

    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("#artistWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title"));
    }
    public void   clickAddToBtn()  throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[title='Add selected songs to…']"));
        addToBtn.click();
        Thread.sleep(5000);
    }

    public void chosePlayList() throws InterruptedException {
        WebElement playListElement = driver.findElement(By.cssSelector("#playlists"));
        playListElement.click();
        Thread.sleep(5000);
    }

    public  String getNotificationText(){
        WebElement notificationtextElement = driver.findElement(By.cssSelector("div.show.success"));
        return notificationtextElement.getText();
    }

}