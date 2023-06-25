import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation(){
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      Open the url in Chrome
        String url = "https://qa.koel.app/";
        String url2 = "https://qa.koel.app/registration.php";
        driver.get(url);

//        Click the Registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("#hel"));
        registrationLink.click();

//        Verify user redirected to Registration page
        Assert.assertEquals(driver.getCurrentUrl(), url2);

//        Quit browser
        driver.close();
    }
}
