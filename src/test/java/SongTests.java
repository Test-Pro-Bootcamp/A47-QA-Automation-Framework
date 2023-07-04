import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
 class SongTest extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void playSongTest(String email, String password ) throws InterruptedException{
       provideEmail(email);
        providePassword(password);
        clickSubmit();
        //Thread.sleep(5000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)

     public void deletePlaylist(String email, String password) throws InterruptedException {
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
