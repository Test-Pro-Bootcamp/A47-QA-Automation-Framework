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



public void clickAddToBtn() {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
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
    }

