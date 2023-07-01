import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
<<<<<<< Updated upstream

import org.openqa.selenium.support.ui.ExpectedConditions;
=======
>>>>>>> Stashed changes
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public static WebDriver driver = null;
<<<<<<< Updated upstream

    public static WebDriverWait wait = null;

    public static String url = "https://qa.koel.app/";


=======
    public static String url = "https://qa.koel.app/";

>>>>>>> Stashed changes
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({ "BaseURL" })
    public void launchBrowser(String BaseURL) {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
<<<<<<< Updated upstream
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);

        wait = new WebDriverWait(driver,Duration.ofSeconds(4));

    }

=======

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);
    }


>>>>>>> Stashed changes
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

<<<<<<< Updated upstream
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][] {
                { "notExisting@email.com", "NotExistingPassword" },
                { "demo@class.com", "" },
                { "", "" }
=======
    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@gmail.com", "NotExistingPassword"},
                {"demo@class.com",""},
                {"",""}
>>>>>>> Stashed changes
        };
    }
    @DataProvider(name = "CorrectLoginProviders")
    public static Object[][] getLoginData() {
        return new Object[][] {
                { "supattra.tangsombutpaiboon@testpro.io", "te$t$tudent1" }
        };
    }
<<<<<<< Updated upstream
    protected static void clickSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[Type='submit']")));
=======

    protected static void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[Type='submit']"));
>>>>>>> Stashed changes
        submitLogin.click();
    }

    protected static void enterPassword(String password) {
<<<<<<< Updated upstream
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
=======
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
>>>>>>> Stashed changes
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected static void enterEmail(String email) {
<<<<<<< Updated upstream
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
=======
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
>>>>>>> Stashed changes
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void clickLogout() {
<<<<<<< Updated upstream
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logout.control")));
=======
        WebElement logoutBtn = driver.findElement(By.cssSelector(".logout.control"));
>>>>>>> Stashed changes
        logoutBtn.click();
    }
    //Profile Tests Helper Functions
    protected static void clickAvatarIcon() {
<<<<<<< Updated upstream
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    protected static String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    protected static void providePassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
=======
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    protected static String generateRadomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    protected static void providePassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
>>>>>>> Stashed changes
        currentPassword.click();
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    protected static void provideProfileName(String name) {
<<<<<<< Updated upstream
        WebElement currentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
=======
        WebElement currentName = driver.findElement(By.cssSelector("input[name='name']"));
>>>>>>> Stashed changes
        currentName.clear();
        currentName.sendKeys(name);
    }
    protected static void clickSaveButton(){
<<<<<<< Updated upstream
        WebElement saveButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("button.btn-submit"))));
        saveButton.click();
    }
    protected static void searchSong(String songName){
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
=======
        WebElement saveButton =  driver.findElement(By.cssSelector(("button.btn-submit")));
        saveButton.click();
    }
    protected static void searchSong(String songName){
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
>>>>>>> Stashed changes
        searchField.clear();
        searchField.sendKeys(songName);
    }

    protected static void clickViewAll(){
<<<<<<< Updated upstream
        WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }
    protected static void clickFirstSong(){
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper>div>div>div>table>tr:nth-child(1)")));
=======
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }
    protected static void clickFirstSong(){
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper>div>div>div>table>tr:nth-child(1)"));
>>>>>>> Stashed changes
        firstSong.click();
    }

    protected static void clickAddButton(){
<<<<<<< Updated upstream
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
        addButton.click();
    }
    protected static void selecteFirstplaylist(){
        WebElement playlistAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper>header>div>div[data-test='add-to-menu']")));
        playlistAdd.isDisplayed();
        WebElement testPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper>header>div>div[data-test='add-to-menu']>section.existing-playlists>ul>li.playlist")));
        testPlaylist.click();
    }
    protected void clickPreviousSong() {
        WebElement PreviousSongButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-prev-btn']")));
=======
        WebElement addButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addButton.click();
    }
    protected static void selecteFirstplaylist(){
        WebElement playlistAdd = driver.findElement(By.cssSelector("section#songResultsWrapper>header>div>div[data-test='add-to-menu']"));
        playlistAdd.isDisplayed();
        WebElement testPlaylist = driver.findElement(By.cssSelector("section#songResultsWrapper>header>div>div[data-test='add-to-menu']>section.existing-playlists>ul>li.playlist"));
        testPlaylist.click();
    }
    protected void clickPreviousSong() {
        WebElement PreviousSongButton = driver.findElement(By.xpath("//i[@data-testid='play-prev-btn']"));
>>>>>>> Stashed changes
        Actions actions = new Actions(driver);
        actions.moveToElement(PreviousSongButton).click().build().perform();
    }
    protected void clickPlaySong(){
<<<<<<< Updated upstream
        WebElement playSongButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/i[@class='fa fa-play']")));
=======
        WebElement playSongButton = driver.findElement(By.xpath("//span/i[@class='fa fa-play']"));
>>>>>>> Stashed changes
        Actions actions = new Actions(driver);
        actions.moveToElement(playSongButton).click().build().perform();
    }
    protected void clickPlayNextSong() {
<<<<<<< Updated upstream
        WebElement nextSongButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
=======
        WebElement nextSongButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
>>>>>>> Stashed changes
        Actions actions = new Actions(driver);
        actions.moveToElement(nextSongButton).click().build().perform();
    }
    protected void verifyPauseButton() {
<<<<<<< Updated upstream
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.pause")));
        pauseButton.isDisplayed();
    }

    //help function for delete playlist
    public  void openPlayList(){
        //WebElement playlist = driver.findElement(By.xpath(".playlist:nth-child(3)"));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }
    public void clickDeletePlayListBtn(){
        WebElement delecteplaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        delecteplaylistBtn.click();
        //If there are songs on the playlist
        //If yes need to click confirm
        //If No
    }

    public  void ConfirmDelete() {
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        //WebElement confirmBtn = driver.findElement(By.cssSelector("button.ok"));
        confirmBtn.click();
    }

    public String getDeletedPlayListMsg (){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}
=======
        WebElement pauseButton = driver.findElement(By.cssSelector("span.pause"));
        pauseButton.isDisplayed();
    }
    public Boolean isSongPlaying() {
        WebElement pauseButton = driver.findElement(By.cssSelector("span.pause"));
        return pauseButton.isDisplayed();
    }
}

>>>>>>> Stashed changes
