import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest {

    public String email;
    public String password;

    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void playSongTest(String email, String password) throws InterruptedException {


        enterEmail(email);

        enterPassword(password);

        clickSubmit();

        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist (String email, String password)throws InterruptedException{
        String deletedPlaylistMsg="Deleted playlist";

        //Put the email field inside the web page
        enterEmail(email);
        // Put the password inside the web app
        enterPassword(password);
        //Click on the submit button
        clickSubmit();

        openPlaylist();
        clickDeletePlaylistBtn(); //optional
        confirmDelete();

        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
        }

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)

    public void renamePlaylist(String email, String password) throws InterruptedException {
        String updatedPlaylistMsg = "Update playlist";

        enterEmail(email);

        enterPassword(password);

        clickSubmit();

        doubleClickPlaylist();
        enterNewPlaylistName();

        Assert.assertTrue(doesPlaylistExist());

    }
}






