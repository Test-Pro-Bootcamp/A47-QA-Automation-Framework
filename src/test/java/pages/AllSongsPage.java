package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage {


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playSong = By.cssSelector("li.playback");

    public void contextClickFirstSong() {
      //  contextClick(firstSong);

    }

    public void choosePlayOption() {
        findElement((WebElement) playSong).click();

    }
//    public void isSongPlaying(){
//        return findElement(soundBar).isDisplayed();
//

}

