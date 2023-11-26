import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework18Test {

    @Test
    public void playSong() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);

//        boolean isSongPlaying =false;
        String songStatus = "";

        //login
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("username.testpro.io");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //click the next song button
        driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]")).click();


        //verifying the pause button is playing
        WebElement pauseButton =driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]/i"));
        String pauseButtonActiveClass = pauseButton.getAttribute("class");
        String desiredClass = "fa fa-play";

        if (pauseButtonActiveClass.contains(desiredClass)) {
           songStatus ="Song is playing";
        } else {
            System.out.println("the song is paused");
            songStatus="Song is paused";
        }


        // Assert that the song is playing

        Assert.assertTrue(Boolean.parseBoolean(songStatus), "Song is playing");

        driver.quit();
    }
}
