import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlayList() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";
        navigateToPage();
        provideEmail("demo@Class.com");
        providePassword("te$t$student");
        clickSummit();
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }
}

