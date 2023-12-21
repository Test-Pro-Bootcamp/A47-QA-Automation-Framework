import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver = null;

    protected static String url = "https://qa.koel.app/";

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }

    public static void setCssTextBox(String selector, String value) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        field.clear();
        field.sendKeys(value);
    }
    public static void setXpathTextBox(String selector, String value) {
        WebElement field = driver.findElement(By.xpath(selector));
        field.clear();
        field.sendKeys(value);
    }

    public static void clickCssButtonDelay(String selector, long delay) {
        WebElement field = driver.findElement(By.cssSelector(selector));

        if(delay > 0) {
            try {
                Thread.sleep(delay);
            }
            catch(InterruptedException ignored) {
                ; // no-op
            }
        }
        field.click();
    }

    public static void clickXpathButtonDelay(String selector, long delay) {
        WebElement field = driver.findElement(By.xpath(selector));

        if(delay > 0) {
            try {
                Thread.sleep(delay);
            }
            catch(InterruptedException ignored) {
                ; // no-op
            }
        }
        field.click();
    }

    public static void clickCssButton(String selector) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        field.click();
    }
    public static void clickXpathButton(String selector) {
        WebElement field = driver.findElement(By.xpath(selector));
        field.click();
    }

    public static String getCssText(String selector) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        return field.getText();
    }

    public static void clickXpathButtonAction(String selector) {
        WebElement field = driver.findElement(By.xpath(selector));
        Actions act = new Actions(driver);
        act.click(field).perform();
    }

    public static boolean getCssIsDisplayed(String selector) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        return field.isDisplayed();
    }

    public static void login(String nm, String pwd) {
        setCssTextBox("input[type='email']", "henry.carter@testpro.io");
        setCssTextBox("input[type='password']", "password");

        clickCssButton("button[type='submit']");
    }
    @AfterMethod
    public static void closeBrowser() {

        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ignored) {
            ; // no-op
        }

        driver.quit();
        driver = null;
    }

}
