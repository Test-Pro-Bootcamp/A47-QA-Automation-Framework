import org.testng.Assert;
import org.testng.annotations.Test;

public class deletePlaylist extends BaseTest {

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)

    public void deletePlaylist(String email, String password) throws InterruptedException{
        String deletedPlaylistMsg = "Deleted Playlist";

        provideEmail(email);
        providePassword(password);
        clickSubmit();

        openPlaylist();
        clickDeletePlaylistBtn();
        confirmDelete();

        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));


    }



}