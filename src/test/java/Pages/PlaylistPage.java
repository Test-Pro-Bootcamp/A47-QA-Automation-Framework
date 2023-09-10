package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver){ super(givenDriver); }

    By deleteBtn = By.cssSelector("button.del");
    By okBtn = By.cssSelector("button.ok");
    By shuffleAllBtn = By.cssSelector("#songsWrapper .fa.fa-random");
    public void deletePlaylist(){
        findElement(deleteBtn).click();
        if (findElement(okBtn) != null){
            click(okBtn);
        }
    }
    public void clickShuffleAll(){
        findElement(shuffleAllBtn).click();
    }
}
