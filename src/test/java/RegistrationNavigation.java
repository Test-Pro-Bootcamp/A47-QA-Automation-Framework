import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationNavigation extends BaseTest {
    @Test
    public void registrationNavigation() {

        openLoginUrl();

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        String registrationURL = "https://qa.koel.app/registration.php";

        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
        driver.quit();
    }
}
