import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        openLoginUrl();
        enterEmail("angel.ayala@testpro.io");
        enterPassword("school!sc0");
        clickSubmit();
        clickNextSong();
        play();
        songValidation();
    }

}
