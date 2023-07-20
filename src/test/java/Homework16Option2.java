import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Option2 extends BaseTest {
   @Test

    public void Registration(){

       //      Added ChromeOptions argument below to fix websocket error
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");


       WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

       // Open the URL for the web page on the Chrome Browser
       String url = "https://qa.koel.app/";
       driver.get(url);


       //click on the submit button Registration
       WebElement submitRegistration = driver.findElement(By.cssSelector("[id='hel']"));
       submitRegistration.click();

       //Verify user redirected to Registration page
       String registrationUrl = "https://qa.koel.app/registration.php";
       Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

       //Quit the browser
       driver.quit();

   }




}
