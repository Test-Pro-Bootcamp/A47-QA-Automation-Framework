import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
        driver.findElement(By.id("hel")).click();
        String url = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
