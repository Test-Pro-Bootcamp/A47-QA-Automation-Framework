import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Homework19  extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException{
        String deletePlayListMsg = "Deleted playlist";

      //  openLoginUrl();
        enterEmail("andrea.guevara@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickPLayList();
        clickDeletePlayList();
        Assert.assertTrue(getNotificationDelete().contains(deletePlayListMsg));
    }
}
