import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        searchSong("Epic");
        clickViewAll();
        selectFirstSongResult();
        clickAddTo();
        choosePlaylist();
        Assert.assertTrue(notificationMessage().contains(notificationText));
    }
    public void searchSong (String songTitle) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type = 'search']"));
        searchField.sendKeys(songTitle);
        Thread.sleep(2000);
    }

    public void clickViewAll () throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(), 'Homework-17')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    public String notificationMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
