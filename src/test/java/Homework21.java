import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
public class Homework21 extends BaseTest {

    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password) {

        enterEmail("victor.flores@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
}
