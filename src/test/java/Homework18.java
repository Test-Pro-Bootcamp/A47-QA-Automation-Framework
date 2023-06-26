import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong(){
        openLoginUrl();
        enterEmail("angel.ayala@testpro.io");
        enterPassword("school!sc0");
        clickSubmit();
    }
}
