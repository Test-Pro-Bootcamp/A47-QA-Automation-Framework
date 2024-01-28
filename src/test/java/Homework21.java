import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    private WebDriver driver=null;
    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    @Test
    public void renamePlaylist() {

//      Added ChromeOptions argument below to fix websocket error

        //login to koel app
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("abdul.hasib.yousufzai@testpro.io");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement playlistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"sidebar\"]"));

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(playlistElement));


        // Action Class methods
        Actions actions = new Actions(driver);
        actions.moveToElement(playlistElement)
                .doubleClick()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .sendKeys("Favorite").click(sideBar)
                .build()
                .perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();

    }
}
