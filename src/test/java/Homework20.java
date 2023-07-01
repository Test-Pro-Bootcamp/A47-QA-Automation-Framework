import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    String deletedPlaylistNotification= "Deleted playlist";
    @Test
    public void deletePlaylist() {
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        clickPlaylist();
        removePlaylist();
        clickOkInPopUp();
        //Thread.sleep(2000);
        Assert.assertTrue(confirmPlaylistDeleted().contains(deletedPlaylistNotification));


    }

    public void userLogin() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitLogin.click();

    }
    public void clickPlaylist() {
        WebElement choosePlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
        choosePlayList.click();
    }
    public void removePlaylist() {
        WebElement deleteThisPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span > button.del.btn-delete-playlist")));
        deleteThisPlaylist.click();
    }
    public void clickOkInPopUp() {
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.alertify > div > div > nav > button.ok")));
        okButton.click();
    }
    public String confirmPlaylistDeleted () {
        WebElement deletedPlaylistNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletedPlaylistNotification.getText();
    }

}

