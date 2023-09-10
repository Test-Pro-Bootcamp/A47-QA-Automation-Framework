import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void playSong(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickLogInbutton();


        songPlay();
        Thread.sleep(5000);

        Assert.assertTrue(isSongPlaying());
    }
}
