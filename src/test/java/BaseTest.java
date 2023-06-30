import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    static ChromeDriver driver = null;
    static String url;
    @BeforeMethod
    @Parameters({"BaseURL"})
    static void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);
    }
    void enterEmail(String email){
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    void clickSubmit() throws InterruptedException{
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Thread.sleep(3000);
    }
    void selectPlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        playlist.click();
        Thread.sleep(4000);
    }
    void clickDeletePlaylist() throws InterruptedException {
        WebElement delete = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        delete.click();
        Thread.sleep(2000);
    }
    String verificationDisplay(){
        WebElement display = driver.findElement(By.cssSelector("div.show.success"));
        return display.getText();
    }
    @AfterMethod
    void closeBrowser(){
        driver.quit();
    }


}