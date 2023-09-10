import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18  extends BaseTest{

    @Test

    public void playSong() throws InterruptedException{

        openLoginUrl();
        enterEmail("andrea.guevara@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickNextSong();
        clickPlay();
        Assert.assertTrue(isSongPlaying());


    }
}
