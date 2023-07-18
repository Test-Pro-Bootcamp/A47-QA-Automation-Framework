import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
//
//        openLoginUrl();
//        enterEmail("demo@class.com");
//        enterPassword("Te$t$tudent");
//        clickSubmit();
//
//        WebElement avatar = driver.findElement(By.cssSelector("#app > div > form > div > img"));
//        Assert.assertTrue(avatar.isDisplayed());

        WebElement enterEmail = driver.findElement(By.cssSelector("[type='email']"));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("irene.perdon@testpro.io");

        WebElement enterPassword = driver.findElement(By.cssSelector("[type='password']"));
        enterPassword.click();
        enterPassword.clear();
        enterPassword.sendKeys("te$t$tudent");

        WebElement clickSubmit = driver.findElement(By.cssSelector("[type='submit']"));
        clickSubmit.click();
        driver.quit();


    }
}
