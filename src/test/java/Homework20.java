import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 {

    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(baseUrl);

        // Login
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("username.testpro.io");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Deleting playlist
        WebElement deleteButton = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deleteButton.click();

        // Confirming the deletion by pressing the OK button in modal popup
        WebElement confirmButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/nav[1]/button[2]"));
        confirmButton.click();

        // Checking deletion confirmation
        String playlistName = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[2]/h1/text()")).getText();

        // Using WebDriverWait for success toaster
        WebElement successToaster = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));

        // Check if success toaster contains the desired class
        String successToasterActiveClass = successToaster.getAttribute("class");
        String desiredClass = "success show";

        if (successToasterActiveClass.contains(desiredClass)) {
            System.out.println("Deleted playlist " + playlistName);
        } else {
            System.out.println("Error occurred !!!");
        }

        driver.quit();
    }
}
