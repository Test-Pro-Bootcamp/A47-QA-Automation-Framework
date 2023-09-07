import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class homework21 extends BaseTest {


    @Test
    public void renamePlayList()  {

        String updatedPlayListMsg = "Updated playlist \"Rename PlayList done\"";

        //  openLoginUrl();
        enterEmail("andrea.guevara@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        doubleClickPlayList();
        enterNewPlayListName();
        Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedPlayListMsg);
    }

}
