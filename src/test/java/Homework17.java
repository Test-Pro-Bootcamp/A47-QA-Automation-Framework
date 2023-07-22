
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddNotificationText = "Added 1 song into";
        navigateToPage();
        enterEmail("admira.mahmutovic@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddNotificationText));

    }


}