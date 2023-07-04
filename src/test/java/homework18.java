import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework18 extends BaseTest {
    @Test
    public void playSong() {

        //open URL
        navigateToPage();

        //login
        provideEmail("alexandra.ward@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //click play next song
        clickPlayNextSong();

        //click play or resume
        clickPlay();

        //verify song is playing
        Assert.assertTrue(verifySoundBar());

        //quit the browser
        driver.quit();


    }
}