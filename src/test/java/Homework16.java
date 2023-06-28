import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16  extends BaseTest {

@Test
public void registrationNavigation() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//open url
    String url = "https://qa.koel.app";
    driver.get(url);

//click registration link
    WebElement registrationButton = driver.findElement(By.cssSelector("[id='hel']"));
    registrationButton.click();

    //confirm user reached registration webpage

    String registrationLink = "https://qa.koel.app/registration.php";

    Assert.assertEquals(driver.getCurrentUrl(), registrationLink);

    driver.quit();








}


}

