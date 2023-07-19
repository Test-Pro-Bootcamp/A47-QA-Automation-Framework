import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

@Test

public void playSong () {

    openLoginUrl();
    enterEmail("beomseo.park@testpro.io");
    enterPassword("te$t$tudent");
    clickSubmit();
    clickPlayNext();
    clickPlay();
    isSongPlay();
}

}
