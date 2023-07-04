import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
<<<<<<< Updated upstream
=======
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
>>>>>>> Stashed changes
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
        // ChromeOptions Argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
    }

    public static void searchForSong(String search) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(search);
        Thread.sleep(2000);
    }

    public static void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public static void clickFirstResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public static void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addTo.click();
        Thread.sleep(2000);
    }

    public static void addToAutomatedPlaylist() throws InterruptedException {
        WebElement automatedPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[7]"));
        automatedPlaylist.click();
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement successBanner = driver.findElement(By.cssSelector("[class='success show']"));
        return successBanner.getText();
    }

    public static void clickPlayNextSong() {
        WebElement playNextSong = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        playNextSong.click();
    }

    public static void clickPlay() {
        WebElement playButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        playButton.click();
    }

    public boolean verifySoundBar() {
        WebElement soundBar = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div/img"));
        return soundBar.isDisplayed();
    }
>>>>>>> Stashed changes
}