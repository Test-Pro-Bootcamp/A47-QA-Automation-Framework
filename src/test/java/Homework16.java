import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        String url = "https://qa.koel.app/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement register = driver.findElement(By.cssSelector("#hel"));
        register.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement verifyButton = driver.findElement(By.cssSelector("#button"));

        Assert.assertTrue(verifyButton.isDisplayed());

        driver.quit();



    }
}
