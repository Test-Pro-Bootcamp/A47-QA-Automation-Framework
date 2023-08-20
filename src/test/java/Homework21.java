import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password) {
        String newPlaylistName = "ANewName";
        String renamePlaylistMessage = "Updated playlist";

        enterEmail(email);
        enterPassword(password);
        clickLogInbutton();

        rightclickPlaylist();
        clickEditOnPlaylist();
        enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(getNotificationMsg().contains(renamePlaylistMessage));
    }
}
