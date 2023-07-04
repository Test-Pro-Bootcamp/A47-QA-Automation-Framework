import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest()throws InterruptedException{
        // Open the URL for the web page on the chrome browser
        openLoginUrl();

        //Put the email field inside the web page
        enterEmail("victor.flores@testpro.io");

        // Put the password inside the web app
        enterPassword("te$t$tudent");

        //Click on the submit button
        clickSubmit();

        //Click play button
        playNextSong();

        //Validate song is playing
        Assert.assertTrue(validateSongPlaying());

        Thread.sleep(10000);
    }

}
