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


        @FindBy(xpath = "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
        public WebElement firstSong;
        @FindBy(xpath = "//span[@class='play']")
        private WebElement playSong;

        @FindBy(xpath = " //*[@id='app']/nav/ul/li[1]")
        private WebElement popupPlayBtn;
        @FindBy(xpath = "//div[@class='bars']")
        private WebElement soundBar;

//        @FindBy(xpath = "[//button[@class='btn-add-to']")
        @FindBy(xpath = "//button[@class='btn-add-to']")
        private WebElement addTo;

        @FindBy(xpath = "//i[@data-testid='play-next-btn']")
        private WebElement playNextBtn;
//        @FindBy(xpath = "//*[@id='songResultsWrapper']//tr[contains(@class,'song-item')])[1]")
        @FindBy(xpath = "//*[@id='songResultsWrapper']//tr[contains(@class,'song-item')][1]")
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

        public AllSongsPage createNewPlaylist() {
              waitForOverlayElement(createPlaylistBtn);
              createPlaylistBtn.click();
              return this;

        }

        public void clickNewPlaylistBtn() {
                waitForOverlayElement(newPlaylistBtn);
                newPlaylistBtn.click();

        }
        public AllSongsPage playNextSong () {
                playNextBtn.click();
                return this;
        }

        public AllSongsPage clickPlayPopup() {
                waitForOverlayElement(popupPlayBtn);
                popupPlayBtn.click();
                return this;
        }

        public AllSongsPage clickPlayBtn () {
                waitForOverlayElement(playSong);
                playSong.click();
                return this;
        }

        public AllSongsPage selectFirstSongResult () {
                waitForOverlayElement(firstResult);

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
        public boolean isSongPlaying () {
                return soundBar.isDisplayed();


        }
}



