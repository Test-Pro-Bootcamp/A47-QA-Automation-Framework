import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";
    @Test

    public void renamePlaylist(){
        String updatedPlaylistMsg = "updated playlist \"Sample Edited Playlist.\"";

        navigateToPage();
        provideEmail("randy.davila@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickplaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

public void doubleClickplaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    actions.doubleClick(playlistElement).perform();
}
public void enterNewPlaylistName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='randy']")));
    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

    playlistInputField.sendKeys(newPlaylistName);
    playlistInputField.sendKeys(Keys.ENTER);
}

public String getRenamePlaylistSuccessMsg() {
    WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    return notification.getText();
}

}
