package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
public class AllSongsPage extends BasePage {
public AllSongsPage (WebDriver givenDriver){

        super(givenDriver);
        }

private void choosePlaylist() {
        WebElement testPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[15]")));
        testPlaylist.click();
        }

private void clickAddToBtn() throws InterruptedException {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
        }

private void selectFirstSongResult() throws InterruptedException{
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")));
        firstResult.click();
        }



private String getNotificationText () {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));
        return notificationElement.getText();
        }
private void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).click().perform();
        }
private void rightClickPlaylist () {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement songElement= driver.findElement(By.xpath(".playlist:nth-child(3)"));
        actions.contextClick(songElement).click().perform();
        }

private void clickDeleteBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();


        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
        confirmDeleteBtn.click();
        }
    }

