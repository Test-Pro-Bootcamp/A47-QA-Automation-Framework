package pages;
import pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }
    By avatarIcon = By.xpath("//img[@class='avatar']");
    By allSongs = By.xpath("//a[@class='songs']");

    public WebElement getAvatarIcon() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }

        public void clickViewAllBtn() {
        waitForOverlay();
            WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
            viewAllBtn.click();

        }
    public void choosePlaylist() {
        waitForOverlay();
        WebElement testPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[15]")));
        testPlaylist.click();
    }

    public void chooseAllSongsList() {
        waitForOverlay();
        findElement(allSongs).click();
    }

        public void verifySearchUrl() {
        waitForOverlay();
            WebElement songResultsWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']")));
            Assert.assertTrue(songResultsWrapper.isDisplayed());
        }

        public void searchForSong(String song){
        waitForOverlay();
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(song);

        }
    public void editPlaylistName() {
        waitForOverlay();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        WebElement editNameField = driver.findElement(By.cssSelector("[name='name']"));
        editNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        editNameField.sendKeys("Test Playlist");
        editNameField.sendKeys(Keys.ENTER);
    }



    public String getChangesText() {
        waitForOverlay();
        WebElement renamePlaylistConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']")));
        return renamePlaylistConfirm.getText();


    }
    public String getNotificationText () {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));
        return notificationElement.getText();
    }

    public void doubleClickChoosePlaylist() {
        waitForOverlay();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).click().perform();
    }
    public void rightClickPlaylist () {
        waitForOverlay();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement songElement= driver.findElement(By.xpath(".playlist:nth-child(3)"));
        actions.contextClick(songElement).click().perform();
    }
    public void clickDeleteBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();


        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
        confirmDeleteBtn.click();
    }
    public String getDeletionText(){
        WebElement deletePlaylistConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']")));
        return deletePlaylistConfirm.getText();
    }

    public void openPlaylist() {
        WebElement openedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[5]/a")));
        openedPlaylist.click();
    }

    }
