import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BsTest{
    @Test
    public static void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";

        // Open the URL for the web page on the chrome browser
        openLoginUrl();

        //Put the email field inside the web page
        enterEmail("victor.flores@testpro.io");

        // Put the password inside the web app
        enterPassword("te$t$tudent");

        //Click on the submit button
        clickSubmit();

        //Search for a song in search field
        searchSong("Pluto");

        clickViewAll();
        selectFirstSong();
        clickAddTo();
        addToPlaylist();
        Assert.assertTrue(getNotification().contains(newSongAddedNotificationText));

        Thread.sleep(5000);

    }
}

