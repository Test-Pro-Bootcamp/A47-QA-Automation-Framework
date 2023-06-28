import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    static ChromeDriver driver = null;
    String url = "https://qa.koel.app/";
    @BeforeMethod
    static void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    static void closeBrowser(){
        driver.quit();
    }
    public void openLoginUrl() {
        driver.get(url);
    }
    public void enterEmail(String emailInput) {
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.click();
        email.clear();
        email.sendKeys(emailInput);
    }
    public void enterPassword(String passwordInput) {
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.click();
        password.clear();
        password.sendKeys(passwordInput);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    void clickNextSong() throws InterruptedException{
        WebElement nextSong = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
        nextSong.click();
        Thread.sleep(2000);
    }

    void play() throws InterruptedException{
        WebElement play = driver.findElement(By.cssSelector("span.play"));
        play.click();
        Thread.sleep(3000);
    }

    void songValidation(){
        WebElement bars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Assert.assertTrue(bars.isDisplayed());
    }
}