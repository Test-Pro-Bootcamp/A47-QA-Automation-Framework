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
    public void registrationNavigation() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";

        driver.get(url);
        WebElement registrationlink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationlink.click();
        String registrationUrl = "https://qa.koel.app/registration.php";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit();

    }

}




