import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{

    @Test
    public void renamePlaylist () throws InterruptedException {
        openLoginUrl();
        enterEmail("beomseo.park@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        openOption();
        clickEdit();
        rename("66");
    }
}