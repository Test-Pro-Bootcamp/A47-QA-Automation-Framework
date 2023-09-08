import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addSongToPlaylistH17 extends BaseTest {
@Test
    public void addSongToPlList() throws InterruptedException{

    String newSongAddedNotificationText = "Added 1 song into";
    navigateToPage();
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmit();
    searchSong("Pluto");
    clickViewAllBtn();
    selectFirstSongResult();
    clickAddToBtn();
    choosePlaylist();
    Assert.assertTrue(getAddToPlaylistSuccessMsg().contains(newSongAddedNotificationText));

}
    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("dev#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAll =driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException{
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button{@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        playlist.click();
        Thread.sleep(2000);

    }

    public String getAddToPlaylistSuccessMsg() {

        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }
}



