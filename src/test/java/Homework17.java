import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    String newSongAddedNotificationText = "Added 1 song into";

    @Test
    public void addSongToPlaylist() throws InterruptedException{
        // openLoginUrl() = this method has been added to the method launchBrowser
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        openSearchField("ketsa");
        clickViewAllSearchResult();
        clickFirstSong();
        clickAddButton();
        addToPlayList();
        Thread.sleep(2000);//we can place it here and selenium will pause for 2 seconds before proceeding with line 22 step
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));



















    }

    public String getNotificationText() throws InterruptedException{
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
        //Thread.sleep(2000);


    }

    public void addToPlayList() throws InterruptedException{
//        WebElement choosePlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/61648']"));
        WebElement choosePlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Olof Triana Playlist')]"));
        choosePlaylist.click();
        Thread.sleep(2000);
    }

    public void clickAddButton() throws InterruptedException {
        WebElement clickAdd = driver.findElement(By.cssSelector("button.btn-add-to"));
        clickAdd.click();
        Thread.sleep(2000);

    }

    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        Thread.sleep(2000);
    }

    private void clickViewAllSearchResult() throws InterruptedException{
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    private void userLogin() throws InterruptedException{
        WebElement submitLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        submitLogin.click();
        Thread.sleep(2000);

    }

    private void openSearchField(String songName) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

}
