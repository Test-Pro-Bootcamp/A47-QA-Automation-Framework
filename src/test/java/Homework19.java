import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    String deletedPlaylistNotification= "Deleted playlist";
    @Test
    public void deletePlaylist() throws InterruptedException{
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        clickPlaylist();
        removePlaylist();
        clickOkInPopUp();
        Thread.sleep(2000);
        Assert.assertTrue(confirmPlaylistDeleted().contains(deletedPlaylistNotification));


    }

    public void userLogin() throws InterruptedException {
        WebElement submitLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        submitLogin.click();
        Thread.sleep(2000);
    }
    public void clickPlaylist() throws InterruptedException{
        WebElement choosePlayList = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a"));
        choosePlayList.click();
        Thread.sleep(2000);
    }
    public void removePlaylist() throws InterruptedException{
        WebElement deleteThisPlaylist = driver.findElement(By.cssSelector("span > button.del.btn-delete-playlist"));
        deleteThisPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickOkInPopUp() throws InterruptedException {
        WebElement okButton = driver.findElement(By.cssSelector("body > div.alertify > div > div > nav > button.ok"));
        okButton.click();
        Thread.sleep(2000);
    }
    public String confirmPlaylistDeleted () throws InterruptedException {
        WebElement deletedPlaylistNotification = driver.findElement(By.cssSelector("div.success.show"));
        return deletedPlaylistNotification.getText();
    }

}
