import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;

public class BaseTest{
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "https://bbb.testpro.io";


    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
   public void launchBrowser(String BaseURL){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(driver);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        driver.get(url);
    }

    @DataProvider(name="IncorrectLoginProvider")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"notExsting@email.com","NotExistingPassword"},
                {"demo@class.com", ""},
                {"",""}
        };
    }
    @DataProvider(name = "CorrectLoginProviders")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"email??@gmail,com", "password"}
                //Data email, password
        };
    }
    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {
    String deletePlaylistMsg = "Delete playlist";
    //enterEmail
    }
    public static void navigateToPage(){
        driver.get(url);
    }
    protected static void provideEmail(String email){
        WebElement emailInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    protected static void openLoginUrl(){
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    protected static String generateRandomName() {
        return UUID.randomUUID().toString().replace(" ", "");
    }
    protected static void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
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
        viewAllSearchResult.clear();

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
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }

    public void clickDeletePlaylistBtn(){
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }
    public void confirmDelete() {
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        confirmBtn.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
    public void doubleClickChoosePlaylist(){
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playListElement).perform();
    }
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();

    }
    public void contextClickFirstSong(){
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }
    public void choosePlaylistOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playBack"))).click();

    }


}