import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test (enabled = false)
    public void addSongToPlaylist() throws InterruptedException{

//        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();

//        Click the search field and enter a song
        searchSong("mid air");
        Thread.sleep(8000);

//        Click the 'View All'
        clickViewAll();

//        Select first song and 'ADD TO...'
        addTo(1);

//        Select which playlist
        selectPlaylist(5);

//        Verify notification message text displays 'Added 1 song into "First Playlist."'
        WebElement msgBox = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(msgBox.getText(), "Added 1 song into \"First Playlist.\"");
        Thread.sleep(8000);

    }

    public void searchSong(String song){
        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(song);
    }
    public void clickViewAll(){
        WebElement viewAllBtn = driver.findElement(By.cssSelector("section.songs button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }
    public void addTo(int x){
        WebElement song = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[" + x + "]"));
        song.click();
        WebElement addToBtn = driver.findElement(By.cssSelector("section#songResultsWrapper .btn-add-to"));
        addToBtn.click();
    }
    public void selectPlaylist(int x){
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='existing-playlists']//ul/li[" + x + "]"));
        playlist.click();
    }
}
