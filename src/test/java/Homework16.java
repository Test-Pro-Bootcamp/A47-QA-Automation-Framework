import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 extends BaseTest {

    public void registrationNavigation(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement regestration = driver.findElement(By.cssSelector("[id='hel']"));
        regestration.click();
        


        WebElement submitButton = driver.findElement(By.cssSelector("[id='button']"));

        Assert.assertTrue(submitButton.isDisplayed());
        driver.quit();



    }


}
