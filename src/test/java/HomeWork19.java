import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{

    @Test
    public void deletePlaylist () throws InterruptedException {
        String deleteMsg = "Deleted playlist";
        openLoginUrl();
        enterEmail("beomseo.park@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        deleteItem();
        deleteBtn();
        Assert.assertTrue(getDeleteMsg().contains(deleteMsg));
    }
}
