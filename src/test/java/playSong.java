import org.testng.Assert;
import org.testng.annotations.Test;

public class playSong extends BaseTest {
    @Test(dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void playSongTest(String email, String password ) throws InterruptedException{
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        //Thread.sleep(5000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
}