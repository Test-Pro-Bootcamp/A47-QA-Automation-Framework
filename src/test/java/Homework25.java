import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Homework25 extends BaseTest{
    @Test
    public void registrationNavigation() throws MalformedURLException
    {
        launchBrowser();
        provideEmail("demo@class.com");
        provideEmail("te$t$tudent");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(),url);
        teardown();
        /*driver=pickBrowser("grid-edge");
        String Url = "https://qa.koel.app/";
        driver.get(Url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        String registrationUrl = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        // driver.quit();*/
    }
}
