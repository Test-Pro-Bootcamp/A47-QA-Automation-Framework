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

        String url2 = "https://qa.koel.app/registration.php";
//      Open the url in Chrome
        openLoginLink();

//        Click the Registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("#hel"));
        registrationLink.click();

//        Verify user redirected to Registration page
        Assert.assertEquals(driver.getCurrentUrl(), url2);
    }
}
