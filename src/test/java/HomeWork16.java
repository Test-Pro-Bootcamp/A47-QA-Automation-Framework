import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeWork16 extends BaseTest {

    @Test
    public void registrationNavigation(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--incognito", "--start-full-screen");
        WebDriver driver = new ChromeDriver(options);
        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationButton = driver.findElement(By.cssSelector("[id='hel']"));
        registrationButton.click();
        WebElement registerNewAccount = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(registerNewAccount.isDisplayed());
        driver.quit();
    }
}


