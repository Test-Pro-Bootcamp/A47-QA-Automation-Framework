import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        login("teststudent@teststudent.com",  "te$t$tudent");
        clickPlayNextSong();
        clickPlaySong();
        Assert.assertTrue(pauseButtonDisplay());
        Assert.assertTrue(soundBarVisualizerDisplay());
    }
}
