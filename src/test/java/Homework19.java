import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework19 {
    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseUrl);

        //login
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("username.testpro.io");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //deleting playlist aa
        driver.findElement(By.xpath("//button[@title='Delete this playlist']")).click();
        //confirming the deletion by pressing the ok button in model popup
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/nav[1]/button[2]")).click();



        //checking deletion confirmation
        String playlistName = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[2]/h1/text()")).getText();
        WebElement successToaster =driver.findElement(By.xpath("//html[1]/body[1]/div[2]/div[1]"));
        String successToasterActiveClass = successToaster.getAttribute("class");
        String desiredClass = "success show";


        if (successToasterActiveClass.contains(desiredClass)) {
            System.out.println("Deleted playlist "+playlistName);
        } else {
            System.out.println("Error occured!");
        }

        driver.quit();

    }
}