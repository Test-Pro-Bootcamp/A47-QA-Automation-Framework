import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylistTest(){
        enterEmailField("daviyontae.floyd@testpro.io");
        enterPasswordField("te$t$tudent");
        clickSubmit();
        int i = 3;
        selectPlaylist(i);

        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#playlists ul> li:nth-child(" + i + ")")));
        String x = playlist.getText();

        deletePlaylist();

        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals(notification.getText(), "Deleted playlist \"" + x + ".\"" );
    }
}
