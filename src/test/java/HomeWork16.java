import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {

    @Test

    public void registrationNavigation() {

        //      Added ChromeOptions argument below to fix websocket error

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Open the koel webpage

        String url = "https://qa.koel.app/";
        driver.get(url);


        // Go to registation link
        WebElement registrationLink = driver.findElement(By.cssSelector("[id = 'hel']"));
        registrationLink.click();


        // check url
        String checkUrl = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), checkUrl);

        
    }
}
