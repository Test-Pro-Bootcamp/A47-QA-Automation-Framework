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
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password'"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submit.click();
    }
    public static void playASong() {
        WebElement playNextSongBtn = driver.findElement(By.className("next"));
        WebElement playSongBtn = driver.findElement(By.xpath("//span[@data-testid = 'play-btn']"));
        playNextSongBtn.click();
        playSongBtn.click();
    }

    public boolean soundBarIsDisplayed() {
        WebElement soundBar = driver.findElement(By.className("bars"));
        return soundBar.isDisplayed();
    }
    public boolean pauseBtnIsDisplayed() {
        WebElement pauseBtn = driver.findElement(By.className("pause"));
        return pauseBtn.isDisplayed();
    }
}