import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String bannerMessage = "Added 1 song into \"Automated Playlisttt.\"";

        //open URL
        navigateToPage();

        //login with valid credentials
        provideEmail("alexandra.ward@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //search for a song (any song)
        searchForSong("song");

        //click view all to display search results
        clickViewAll();

        //click first song in search results
        clickFirstResult();

        //click add to...
        clickAddTo();

       // add song to playlist
        addToAutomatedPlaylist();

        //verify notification message appears
        getNotificationText();

        // print notification value in order to debug.  In the future use a logger like SLF4J instead of print statements.
        System.out.println("bannerMessage = " + bannerMessage);
        System.out.println("Notification text: " + getNotificationText());

        //verify notification message contains text "added 1 song into {playlist name}"
        Assert.assertEquals(getNotificationText(), bannerMessage, "The expected banner message does not match the Notification Text.");

        //quit the browser
        driver.quit();

    }
}