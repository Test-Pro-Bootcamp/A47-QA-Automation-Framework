import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        navigateToPage();
        provideEmail("jasmynmedina1@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        newPlaylistName();
        Assert.assertTrue(playlistIsDisplayed());
    }
}
