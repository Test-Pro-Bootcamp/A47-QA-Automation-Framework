import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
WebDriver driver = null;
public String url = "https://qa.koel.app/";
    @BeforeSuite
   static void setupClass() {WebDriverManager.chromedriver().setup();}
@BeforeMethod
static void launchbrowser() {
        //Added ChromeOptions argument below to fix websocket error
}
 ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
   driver = new ChromeDriver(options);

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) }
      @AfterMethod
       public void closebrowser() {
          driver.quit();
      }
}

//    @BeforeSuite
//    static void setupClass() {WebDriverManager.chromedriver().setup();}
//    //Added ChromeOptions argument below to fix websocket error
//    ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//    WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();


