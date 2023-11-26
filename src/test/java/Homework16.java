import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework16 {

    @Test
    public void registrationNavigation() {
       // System.setProperty("webdriver.chrome.driver", );
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.koel.app/");

        WebElement registrationLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div[2]/a"));
        registrationLink.click();

        // Verify that you are redirected to the Registration page
        String expectedTitle = "Koel Registration/Reset";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        driver.quit();
    }
}