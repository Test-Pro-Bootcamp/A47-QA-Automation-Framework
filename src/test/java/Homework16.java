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
    public void registrationNavigation() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebElement registration_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/registration.php']")));

        String url = "https://qa.koel.app/";
        driver.get(url);

        //Click on Registration button
        WebElement registration_button = driver.findElement(By.cssSelector("a[href='/registration.php']"));
        registration_button.click();

        //Verify that you are redirected to Registration page
        String registrationUrl = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit();
    }


}
