import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework16 {
    @Test
    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //open URL
        String url = "https://qa.koel.app/";
        driver.get(url);

        //click registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        //verify redirection to page using Assert method
        WebElement registrationButton = driver.findElement(By.cssSelector("[value='register']"));
        Assert.assertTrue(registrationButton.isDisplayed());

        //quit the browser
        driver.quit();





    }

}
