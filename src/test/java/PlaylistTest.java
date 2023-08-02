import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {
    String newPlaylistName = "Testing Playlist";
    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.doubleClickPlaylist();
        enterNewPlayListName();
        Assert.assertTrue(doesPlayListExist());
    }
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        loginPage.login();
        homePage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }
    @Test
    public void deletePlaylist() throws InterruptedException {
        String deleteMsg = "Deleted playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.openPlaylist();
        homePage.deletePlaylistBtn();
        homePage.clickonConfirmationOkBtn();
        homePage.getDeleteMsg();
        Assert.assertTrue(homePage.getDeleteMsg().contains(deleteMsg));
    }
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.searchSong("Pluto");
        homePage.clickViewAll();
        homePage.selectFirstSongResult();
        homePage.clickAddTo();
        homePage.choosePlaylist();
        Assert.assertTrue(homePage.notificationMessage().contains(notificationText));
    }
    public boolean doesPlayListExist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlaylistName + "']")));
        return playListElement.isDisplayed();
    }
    public void enterNewPlayListName(){
        WebElement playListInputField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }
}