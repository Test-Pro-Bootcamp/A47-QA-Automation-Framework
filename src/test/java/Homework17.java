import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification = "Added 1 song into";

        openLoginUrl();

        enterEmail("aimee.woodside@testpro.io");

        enterPassword("te$t$tudent13");

        clickLogInbutton();

        searchSong("beautiful");

        clickViewAllSearchBtn();

        clickFirstSongSearchResult();

        clickAddToBtn();

        selectPlayList();

        getNotificationMessage();

        Assert.assertTrue(getNotificationMessage().contains(newSongAddedNotification));
    }
}
