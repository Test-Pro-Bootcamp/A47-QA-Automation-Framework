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
        Thread.sleep(5000);

        searchSong("Dark Days");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

    }
}
