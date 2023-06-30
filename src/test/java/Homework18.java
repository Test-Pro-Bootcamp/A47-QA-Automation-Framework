import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.util.*;
public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        //open URL
        openLoginUrl();
        //input email
        enterEmail("matt.pierce@testpro.io");
        //input password
        enterPassword("te$t$tudent");
        //click submit
        clickSubmit();

        //play Next Song
        playNextSong();
        // verify song is playing
        songIsPlaying();
    }

    public void songIsPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@class='bars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    public void playNextSong() throws InterruptedException{
        WebElement nextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextSong.click();

        WebElement mediaPlayer = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        mediaPlayer.click();
        Thread.sleep(5000);
    }
}
