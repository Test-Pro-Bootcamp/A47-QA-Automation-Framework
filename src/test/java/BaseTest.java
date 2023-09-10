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
    public void launchBrowser(){
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }


    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public static void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    // Put Lobo on SearchBar
    public void searchSong(){
        WebElement searchBar = driver.findElement(By.cssSelector("[type='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("lobo");
    }

    //Click on button View All
    public void setClickViewAll(){
        WebElement clickViewAll = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        clickViewAll.click();
    }


    // Select first Song
    public void setSelectFirstSong() throws InterruptedException {
        WebElement selectFirstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        selectFirstSong.click();
        Thread.sleep(3000);
    }


    // Select Add To
    public void addTo() throws InterruptedException {
        WebElement selectAddTo = driver.findElement(By.cssSelector(".btn-add-to"));
        selectAddTo.click();
        Thread.sleep(3000);
    }


    // Select Add to Gym Playlist
    public void choosePlayList() throws InterruptedException{
        WebElement AddGymPlayList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'GYM Playlist')]"));
        AddGymPlayList.click();
        Thread.sleep(3000);
    }

    // Verity notification message
   public String notificationAdded() {
     WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
     return notificationMessage.getText();

  }
}