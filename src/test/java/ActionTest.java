import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class ActionTest extends BaseTest {
    @Test
    public void registrationNavigation() {
        getDriver().findElement(By.id("hel")).click();
        String url = "https://qa.koel.app/registration.php";
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

}