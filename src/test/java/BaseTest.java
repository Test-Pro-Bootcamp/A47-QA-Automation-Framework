import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

import java.time.Duration;

public class BaseTest {
     @FindBy (css="[type='email']")
    WebElement emailInput;

    @FindBy (css="[type='password']")
    WebElement passwordInput;

    @FindBy (xpath = "//section[@id='songResultsWrapper']")
    WebElement songResultsWrapper;

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    PageFactory.initElements(driver, this);
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters ({"BaseURL"})
    private void launchBrowser(String BaseURL) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

    }
    @AfterMethod
    public void logout() {

        driver.quit();
    }
    @DataProvider (name="CorrectLoginProviders")
    protected static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"matt.pierce@testpro.io", "te$t$tudent"}
        };
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void enterEmail(String email){

        emailInput.click();
        emailInput.clear();
        //inputs valid email address into email input field
        emailInput.sendKeys(email);
    }

    protected static void enterPassword(String password) throws InterruptedException{

        passwordInput.clear();
        //inputs valid password for login into password field
        passwordInput.sendKeys(password);
    }

    private void clickSubmit() throws InterruptedException{
       @FindBy (css="[type='submit'")
       WebElement loginBtn;

        loginBtn.click();
    }

    @Test
    private void addSongToPlaylist(String email, String password) {
        String newSongAddedNotificationText = "Added 1 song into";
        //open url
        //openLoginUrl();
        //input email
        enterEmail(email);
        //input password
        enterPassword(password);
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

    private void choosePlaylist() {

        @FindBy (xpath = "//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[3]")
        WebElement testPlaylist;
        testPlaylist.click();
    }

    private void clickAddToBtn() {
        @FindBy (xpath = "//button[@class='btn-add-to']")
        WebElement addTo;
        addTo.click();
    }

    private void selectFirstSongResult() {
        @FindBy (xpath = "//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")
        WebElement firstResult;
        firstResult.click();
    }

    private void clickViewAllBtn() {
        @FindBy (xpath ="//button[@data-test='view-all-songs-btn']")
        WebElement viewAllBtn;
        viewAllBtn.click();

    }

    public void verifySearchUrl()  {
       @FindBy (xpath = "//section[@id='songResultsWrapper']")
        WebElement songResultsWrapper;

        Assert.assertTrue(songResultsWrapper.isDisplayed());
    }

    private void searchForSong(String song) {
        @FindBy (css = "[type='search']")
        WebElement searchField;

        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);

    }

    private String getNotificationText () {
        @FindBy (css = "div.alertify-logs.top.right")
        WebElement notificationElement;
        return notificationElement.getText();
    }
    private void doubleClickChoosePlaylist() {
        @FindBy (css = ".playlist:nth-child(3)")
        WebElement playlistElement;

        actions.doubleClick(playlistElement).click().perform();
    }
    private void rightClickPlaylist () {
        @FindBy (css = ".playlist:nth-child(3)")
        WebElement songElement;

        actions.contextClick(songElement).click().perform();
    }

    public void clickDeleteBtn() {
        @FindBy (xpath = "//button[@class='del btn-delete-playlist']")
        WebElement deletePlaylistBtn;
        deletePlaylistBtn.click();


        @FindBy(xpath = "//button[@class='ok']")
        WebElement confirmDeleteBtn;

        confirmDeleteBtn.click();
    }
}