import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylistTest() throws InterruptedException{

        //        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();

        int i = 3;
        selectPlaylist(i);
        WebElement playlist = driver.findElement(By.cssSelector("section#playlists ul> li:nth-child(" + i + ")"));
        String x = playlist.getText();
        Thread.sleep(5000);

        deletePlaylist();

//        Verify 'Deleted playlist notification
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notification.getText(), "Deleted playlist \"" + x + ".\"");
    }
}
