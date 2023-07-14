package pages;
import pages.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AllSongsPage extends BasePage {
public AllSongsPage (WebDriver givenDriver){

        super(givenDriver);
        }

        By firstSong = By.cssSelector(".all-song tr.songs-item:nth-child(1)");
        By playSong = By.xpath("/span[@class='play']");

        By soundBar = By.xpath("//div[@class='bars']");



        public void clickAddToBtn() {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
        }
        public void choosePlaySong() {
                findElement(playSong).click();
        }
        public void playNextSong() {
                WebElement playNextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
                playNextBtn.click();
        }

public void selectFirstSongResult() {
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")));
        firstResult.click();
        }
        public void clickDeleteBtn() {
                WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
                deletePlaylistBtn.click();


                WebElement confirmDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
                confirmDeleteBtn.click();
        }

        public void contextClickFirstSong() {
                contextClick(firstSong);
        }
        public boolean isSongPlaying()  {
                return findElement(soundBar).isDisplayed();
        }


    }

