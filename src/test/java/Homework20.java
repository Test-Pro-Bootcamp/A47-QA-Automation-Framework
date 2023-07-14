import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String deleteMsg = "Deleted playlist";
        navigateToPage();
        provideEmail("jasmynmedina1@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        deletePlaylistBtn();
        getDeleteMsg();
        Assert.assertTrue(getDeleteMsg().contains(deleteMsg));
    }
}
