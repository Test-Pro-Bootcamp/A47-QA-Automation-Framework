import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed());


    }
}
