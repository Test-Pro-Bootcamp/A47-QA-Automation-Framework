import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTests extends BaseTest{
    String newPlaylistName = "Updated playlist";
    @Test
    public void renamePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
//        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        Thread.sleep(2000);
        homePage.doubleClickPlaylist().changePlaylistInputField();
//        Assert.assertTrue(homePage.doesPlaylistExist().contains(newPlaylistName));

    }



    //public void doubleClickPlaylist() {
        //WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
       // actions.doubleClick(choosePlayList).perform();

   // }
    //public void changePlaylistInputField(){
        //WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        //playListInputField.sendKeys("NewPlaylistName");
        //playListInputField.sendKeys(Keys.ENTER);
    //}

    //public String doesPlaylistExist() {
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //return playlistElement.getText();
   // }
    String newSongAddedNotificationText = "Added 1 song into";
    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.openSearchField("ketsa").clickViewAllSearchResult().clickFirstSong().clickAddButton().addToPlayList();
        Assert.assertTrue(homePage.getNotificationText().contains(newSongAddedNotificationText));

    }

    String deletedPlaylistNotification= "Deleted playlist";
    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.clickOnPlaylist().removePlaylist().clickOkInPopUp();
        Assert.assertTrue(homePage.confirmPlaylistDeleted().contains(deletedPlaylistNotification));

    }


}


