import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
<<<<<<< Updated upstream
=======

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

    public void clickLogInbutton() {
        WebElement LogInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        LogInButton.click();
    }

    // Profile Tests Helper Functions
    protected static void displayAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.isDisplayed();
    }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchSongInput = driver.findElement(By.cssSelector("input[type='search']"));
        searchSongInput.click();
        searchSongInput.clear();
        searchSongInput.sendKeys(songTitleKeyword);
        Thread.sleep(3000);
    }

    public void clickViewAllSearchBtn() throws InterruptedException {
        WebElement ViewAllSearchButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        ViewAllSearchButton.click();
        Thread.sleep(3000);
    }

    public void clickFirstSongSearchResult() throws InterruptedException {
        WebElement FirstSongSearchResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        FirstSongSearchResult.click();
        Thread.sleep(3000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement AddToButton = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        AddToButton.click();
        Thread.sleep(3000);
    }

    public void selectPlayList() throws InterruptedException {
        WebElement selectedPlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        selectedPlaylist.click();
        Thread.sleep(3000);
    }

    public String getNotificationMessage() {
        WebElement notificationAlert = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationAlert.getText();
        
        //Bring Changes to HW 18
    }

>>>>>>> Stashed changes
}