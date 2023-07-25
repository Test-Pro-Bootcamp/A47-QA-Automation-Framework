import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests  extends BaseTest {

@Test
public void registrationNavigation() {

//click registration link
    WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='hel']")));
    registrationButton.click();

    //confirm user reached registration webpage

    String registrationLink = "https://qa.koel.app/registration.php";

    Assert.assertEquals(driver.getCurrentUrl(), registrationLink);

    //driver.quit();








}


}

