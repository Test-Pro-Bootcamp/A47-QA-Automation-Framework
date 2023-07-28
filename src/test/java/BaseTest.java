import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
       public static WebDriverManager driver = null;
       public static String url = ("https://qa.koel.app/");

       @BeforeSuite
       static void setupClass() {
           WebDriverManager.chromedriver().setup();
       }

       @BeforeSuite
       public void launchBrowser() {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote-allow-origins=*");
           WebDriver driver = new ChromeDriver(options);
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       }

       @AfterMethod
       public void closeBrowser() {
           driver.quit();
       }

       public void provideEmail(String email) {
           WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
           emailField.clear();
           emailField.sendKeys(email);
       }

       public void providePassword(String password) {
           WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
           passwordField.clear();
           passwordField.sendKeys(password);
       }

       public void clickSubmit() {
           WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
           submit.click();
       }
   }