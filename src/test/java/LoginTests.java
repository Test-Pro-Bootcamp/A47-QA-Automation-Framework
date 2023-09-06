import org.checkerframework.checker.units.qual.A;
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


        String url ="https://qa.koel.app/" ;
        driver.get(url);

        WebElement emailIn = driver.findElement(By.cssSelector("[type='email']"));
        emailIn.click();
        emailIn.clear();
        emailIn.sendKeys("demo@class.com");

      /*  WebElement passwordIn = driver.findElement(By.cssSelector("[type='password']"));
        passwordIn.click();
        passwordIn.clear();
        passwordIn.sendKeys("te$t$tudent");
*/

        WebElement submitB = driver.findElement(By.cssSelector("button[type='submit']"));
        submitB.click();


        //  Assert.assertTrue(avatar.isDisplayed());

        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertTrue(submitB.isDisplayed());
        driver.quit();
    }
}
