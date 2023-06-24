import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void registrationNavigation() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to "https://qa.koel.app/"
        driver.get("https://qa.koel.app/");

        // Click the Registration link
        WebElement registrationLink = driver.findElement(By.linkText("Registration"));
        registrationLink.click();

        // Verify that you are redirected to the Registration page using Assert
        String expectedTitle = "Koel - Registration";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Close the browser
        driver.quit();
    }
}
