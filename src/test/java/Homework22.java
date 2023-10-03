import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;

public class Homework22 extends BaseTest{
@Test
    public void renamePlaylist() {
    String newPlaylistName = "Test Pro Edited playlist";
    String updatedPlaylistMsg = "updated playlist \"Test pro Edited Playlist.\"";

    LoginPage loginPage = new LoginPage(driver);
    Homepage homepage = new Homepage(driver);

    loginPage.login();
    homepage.doubleClickPlaylist();
    homepage.enterNewPlaylistName(newPlaylistName);
    Assert.assertEquals(homepage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
}

}
