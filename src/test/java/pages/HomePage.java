package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    String newPlaylistName = "Updated Playlist";
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector(".avatar");
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public WebElement hoverPlay() {
        WebElement playBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(playBtn).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }
    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playback']"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }
    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found" + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }

    public void choosePlaylistByName(String playlistName ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains (text(),'Happy Holidays')]"))).click();
    }
    public boolean doesPlaylistExists(){
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" +newPlaylistName+"']")));
        return playListElement.isDisplayed();
    }
    public void enterNewPlaylistName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlaylist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='active']")));
        actions.doubleClick(playListElement).perform();
    }
}
