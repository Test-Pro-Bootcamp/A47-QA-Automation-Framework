import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    String newSongAddedNotificationText = "Added 1 song into";

    @Test
    public void addSongToPlaylist() {
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        openSearchField("ketsa");
        clickViewAllSearchResult();
        clickFirstSong();
        clickAddButton();
        addToPlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));



    }

    public String getNotificationText() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationElement.getText();
        //Thread.sleep(2000);
    }

    public void addToPlayList() {
//        WebElement choosePlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/61648']"));
        WebElement choosePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Olof Triana Playlist')]")));
        choosePlaylist.click();
    }

    public void clickAddButton() {
        WebElement clickAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
        clickAdd.click();
    }

    public void clickFirstSong()  {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        firstSong.click();
    }

    public void clickViewAllSearchResult() {
        WebElement viewAllSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearchResult.click();
    }

    public void userLogin() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitLogin.click();

    }

    public void openSearchField(String songName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
    }

}
