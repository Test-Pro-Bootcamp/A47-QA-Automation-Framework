import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));

        emailField.click();
        emailField.sendKeys("privet2@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));

        passwordField.click();
        passwordField.sendKeys("Privet1rive$");



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement submitField = driver.findElement(By.cssSelector("[type='submit']"));
        submitField.click();


driver.quit();
    }
}
