import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylistTest() {
        login();

        int i = 3;
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists ul> li:nth-child(" + i + ") a")));
        actions.doubleClick(e).perform();
        String x = "First Mix";

        renamePlaylist(x);

        Assert.assertEquals(e.getText(), x);
    }

}
