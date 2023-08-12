import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {
        String deletedPlaylistMessage = "Deleted playlist";

        enterEmail(email);
        enterPassword(password);
        clickLogInbutton();

        openPlayList();
        deletePlaylistBtn();

        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMessage));
    }
}
