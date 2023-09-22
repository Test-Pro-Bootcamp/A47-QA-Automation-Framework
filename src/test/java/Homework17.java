import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {

    String expectedSongAddedMessage = "Added 1 song into";

    navigateToPage();
    provideEmail("randy.davila@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    Thread.sleep(2000);
    searchSong(  "lament");
    clickViewAllBtn();
    selectFirstSongResult();
    clickAddToBtn();
    choosePlaylist();
    Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public void searchSong (String name) throws  InterruptedException{
        WebElement searchField = driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type='search']")));
        searchField.sendKeys(name);
    }
public void clickViewAllBtn() throws InterruptedException{
        WebElement ViewAll = driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@data-test='view-all-songs-btn']")));
        ViewAll.click();
}

public void selectFirstSongResult() throws InterruptedException{
        WebElement FirstSong = driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        FirstSong.click();
}

public void clickAddToBtn() throws InterruptedException{
        WebElement addToButton = driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addToButton.click();
        Thread.sleep(2000);
}

public void choosePlaylist() throws InterruptedException{
        WebElement Playlist = driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]")));
        Playlist.click();
}


public String getAddToPlaylistSuccessMsg() throws InterruptedException{
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
}

}
