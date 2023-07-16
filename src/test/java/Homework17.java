import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";
        openLoginUrl();
        enterEmail("irene.perdon@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

        searchSong("Dark Days");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlayList();

        Assert.assertTrue(getNotification().contains(newSongAddedNotificationText));

    }
}
