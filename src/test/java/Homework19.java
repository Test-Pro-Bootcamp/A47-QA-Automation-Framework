import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    String message= "Deleted playlist";
    @Test

    void deletePlaylist() throws InterruptedException {


        enterEmail("angel.ayala@testpro.io");
        enterPassword("school!sc0");
        clickSubmit();
        selectPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(verificationDisplay().contains(message));


    }
}
