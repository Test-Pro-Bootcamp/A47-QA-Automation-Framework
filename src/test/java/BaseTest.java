import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
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
        String url = baseUrl;
        driver.get(url);
    }

    @AfterMethod
    static void quitBrowser(){
//        Quit browser
        driver.quit();
    }
    /*LOGIN HELPER FUNCTIONS*/
    public void enterEmailField(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPasswordField(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
    /*USER PROFILE HELPER FUNCTIONS*/
    public void clickUsername(){
        WebElement username = driver.findElement(By.cssSelector("span.name"));
        username.click();
    }
    public void currentPassword(String pass){
        WebElement currPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currPasswordField.click();
        currPasswordField.clear();
        currPasswordField.sendKeys(pass);
    }
    public String generateUsername(){
        String name = UUID.randomUUID().toString().replace("-", "");
        return name.substring(0, 7);
    }
    public void changeUsername(String name){
        WebElement usernameField = driver.findElement(By.cssSelector("#inputProfileName"));
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(name);
    }
    public void clickSave(){
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }

    public void clickPlayNext(){
        WebElement playNextBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextBtn.click();
    }

    public void clickPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
        playBtn.click();
    }

    public void selectPlaylist(int x){
        WebElement playlist = driver.findElement(By.cssSelector("section#playlists ul> li:nth-child(" + x + ")"));
        playlist.click();
    }

    public void deletePlaylist() throws InterruptedException{
        WebElement deleteBtn = driver.findElement(By.cssSelector("button.del"));
        deleteBtn.click();
        Thread.sleep(5000);
        /*for non-empty playlist
        WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();
        Thread.sleep(5000);*/
    }
}