import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        Thread.sleep(5000);

    }
    @AfterMethod
    public void logout() {

        driver.quit();
    }
    @DataProvider (name="CorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"matt.pierce@testpro.io", "te$t$tudent"},
                {"demo@class.com", "te$t$tudent"}
        };
    }

    public static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void enterEmail(String email) throws InterruptedException{
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        //inputs valid email address into email input field
        emailInput.sendKeys(email);
        Thread.sleep(5000);
    }

    protected static void enterPassword(String password) throws InterruptedException{
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        //inputs valid password for login into password field
        passwordInput.sendKeys(password);
        Thread.sleep(5000);
    }

    public void clickSubmit() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
        Thread.sleep(5000);
    }

    @Test
    public void addSongToPlaylist() throws InterruptedException{
        String newSongAddedNotificationText = "Added 1 song into";
        //open url
        //openLoginUrl();
        //input email
        enterEmail("matt.pierce@testpro.io");
        //input password
        enterPassword("te$t$tudent");
        //click submit
        clickSubmit();

        //search for song
        searchForSong("Dark Days");
        //click View All Btn
        clickViewAllBtn();
        // verify on search results page
        verifySearchUrl();
        //select the first song returned in the search
        selectFirstSongResult();
        //click Add To Btn
        clickAddToBtn();
        //choose Playlist to add the song to
        choosePlaylist();
        //checking for success message notification
        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));


    }

    public void choosePlaylist() throws InterruptedException{
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[15]"));
        testPlaylist.click();
        Thread.sleep(5000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addTo.click();
        Thread.sleep(5000);
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstResult = driver.findElement(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]"));
        firstResult.click();
        Thread.sleep(5000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(5000);
    }

    public void verifySearchUrl() throws InterruptedException {
        WebElement songResultsWrapper = driver.findElement(By.xpath("//section[@id='songResultsWrapper']"));
        Assert.assertTrue(songResultsWrapper.isDisplayed());
        Thread.sleep(5000);
    }

    public void searchForSong(String song) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
        Thread.sleep(5000);
    }

    public String getNotificationText () {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationElement.getText();
    }
}