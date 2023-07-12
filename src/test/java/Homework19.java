import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest{

        @Test
        public void deletePlaylist() {
            String deletedPlaylistMsg = "Deleted playlist";

            //Put the email field inside the web page
            enterEmail("dulcealergica@yahoo.com");
            // Put the password inside the web app
            enterPassword("te$t$tudent");
            //Click on the submit button
            clickSubmit();

            openPlaylist();
            clickDeletePlaylistBtn();
            confirmDelete();

            Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));



        }

}


