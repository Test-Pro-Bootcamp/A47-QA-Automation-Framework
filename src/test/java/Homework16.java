import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Homework16 extends BaseTest{
    /*
    -Create a test case, registrationNavigation() using @Test annotation.
    -Using Selenium, navigate to "https://qa.koel.app/".
    -Click the Registration link.
    -Verify that you are redirected to Registration page using Assert method.
     */
    @Test
    public void registrationNavigation(){

        //ChromeOptions argument
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Open the webpage
        String url = "https://qa.koel.app/";
        driver.get(url);

        //click on Registration link
        WebElement registerLink = driver.findElement(By.xpath("//a[@id='hel']"));
        registerLink.click();

        //Verify redirected to Registration page
        Assert.assertNotEquals(driver.getCurrentUrl(),url);

        String registerUrl = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),registerUrl);

        WebElement registerButton = driver.findElement(By.xpath("//input[@id='button']"));
        Assert.assertTrue(registerButton.isDisplayed());

        //Quit
        driver.quit();

    }
}

