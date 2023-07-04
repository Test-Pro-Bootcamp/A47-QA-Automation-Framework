import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Add 1 song into";
        //Open the URL
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong( "Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        chosePlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));
        

    }
}





