import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import org.openqa.selenium.*;


import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException{
        //open url
        openLoginUrl();
        //input email
        enterEmail("matt.pierce@testpro.io");
        //input password
        enterPassword("te$t$tudent");
        //click submit
        clickSubmit();

        //clicks Play Next BTN
        playNextSong();
        //clicks Media Player
        playButton();
        //verifies song is playing
        songIsPlaying();



    }

    public void playButton() throws InterruptedException {
        WebElement mediaPlayer = driver.findElement(By.xpath("//span[@class='play']"));
        mediaPlayer.click();
    }

    public void songIsPlaying() throws InterruptedException {
        WebElement soundBar = driver.findElement(By.xpath("//div[@class='bars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    public void playNextSong() throws InterruptedException{
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextBtn.click();
        Thread.sleep(5000);
    }


}

