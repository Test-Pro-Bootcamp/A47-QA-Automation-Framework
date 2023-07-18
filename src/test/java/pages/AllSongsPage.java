package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AllSongsPage extends BasePage {
public AllSongsPage (WebDriver givenDriver) {

        super(givenDriver);
}


        @FindBy(css = "[.all-song tr.songs-item:nth-child(1)]")
        private WebElement firstSong;
        @FindBy(xpath = "[/span[@class='play']")
        private WebElement playSong;
        @FindBy(xpath = "[div[@class='bars]")
        private WebElement soundBar;

        @FindBy(xpath = "[//button[@class='btn-add-to']")
        private WebElement addTo;

        @FindBy(xpath = "//i[@data-testid='play-next-btn']")
        private WebElement playNextBtn;
        @FindBy(xpath = "//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")
        private WebElement firstResult;

        @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
        private WebElement deletePlaylistBtn;

        @FindBy(xpath = "//button[@class='ok']")
        private WebElement confirmDeleteBtn;

        @FindBy(xpath = "//i[@class='fa fa-plus-circle create']")
        private WebElement createPlaylistBtn;

        @FindBy (xpath ="//li[@data-testid='playlist-context-menu-create-simple']")
        private WebElement newPlaylistBtn;
        public void clickAddToBtn () {
                addTo.click();
        }
        public void choosePlaySong () {
                playSong.click();
        }

        public void createNewPlaylist() {
                createPlaylistBtn.click();

        }

        public void clickNewPlaylistBtn() {
                newPlaylistBtn.click();

        }
        public AllSongsPage playNextSong () {
                playNextBtn.click();
                return this;
        }

        public AllSongsPage selectFirstSongResult () {
                firstResult.click();
                return this;
        }
        public AllSongsPage clickDeleteBtn () {
                deletePlaylistBtn.click();

                confirmDeleteBtn.click();
                return this;
        }

        public AllSongsPage contextClickFirstSong () {
                actions.contextClick(firstSong);
                return this;
        }
        public Boolean isSongPlaying () {
                return findElement((By) soundBar).isDisplayed();


        }
}



