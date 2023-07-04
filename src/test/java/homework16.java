import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //open URL
        driver.get(url);

        //click registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        //verify redirection to page using Assert method
        String registrationURL = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

        //quit the browser
        driver.quit();


    }

}
