import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    static WebDriver driver;
    public WebDriverWait wait;
    String url;
    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void initializeBrowser(String baseUrl){
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @AfterMethod
    static void quitBrowser(){
//        Quit browser
        driver.quit();
    }

    @DataProvider(name="ValidLoginData")
    public static Object[][] validParams(){
            return new Object[][]{
                    {"daviyontae.floyd@testpro.io", "te$t$tudent"},
                    {"demo@class.com", "te$t$tudent"}
            };
    }
    @DataProvider(name="InvalidLoginData")
    public static Object[][] invalidParams(){
        return new Object[][]{
                {"daviyontae.floyd@testpro.io", ""},
                {"invalid.email@gamil.com", "te$t$tudent"},
                {"", ""}
        };
    }
    /*LOGIN HELPER FUNCTIONS*/
    public void enterEmailField(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPasswordField(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }
    /*USER PROFILE HELPER FUNCTIONS*/
    public void clickUsername(){
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        username.click();
    }
    public void currentPassword(String pass){
        WebElement currPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileCurrentPassword")));
        currPasswordField.click();
        currPasswordField.clear();
        currPasswordField.sendKeys(pass);
    }
    public String generateUsername(){
        String name = UUID.randomUUID().toString().replace("-", "");
        return name.substring(0, 7);
    }
    public void changeUsername(String name){
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileName")));
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(name);
    }
    public void clickSave(){
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-submit")));
        saveBtn.click();
    }

    /*SONG PLAY HELPER FUNCTIONS*/
    public void clickPlayNext(){
        WebElement playNextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play next song']")));
        playNextBtn.click();
    }

    public void clickPlay(){
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.play")));
        playBtn.click();
    }

    /*PLAYLIST HELPER FUNCTIONS*/
    public void selectPlaylist(int x){
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#playlists ul> li:nth-child(" + x + ")")));
        playlist.click();
    }

    public void deletePlaylist(){
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del")));
        deleteBtn.click();

        /*for non-empty playlist
        WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();*/
    }
}