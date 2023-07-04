import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        String deletedPlaylistMsg = "Delete playlist";


            provideEmail("art1234@mail.com");
            providePassword("te$t$tudent");
            clickSubmit();

            openPlaylist();
            clickDeletePlaylistBtn();
            confirmDelete();

            Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));


        }
}
