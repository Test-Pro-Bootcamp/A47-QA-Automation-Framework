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

        // click play next song
        public void clickNextSong() {
            WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
            playNextSong.click();

        }
        public void clickPlay(){
                WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
                playButton.click();
            }

            public boolean isSongPlaying(){
            WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            return soundBar.isDisplayed();
        }

        }
