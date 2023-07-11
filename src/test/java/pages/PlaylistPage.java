package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "button.del")
    private WebElement deleteBtn;
    @FindBy(css = "button.ok")
    private WebElement okBtn;
    @FindBy(css = "#songsWrapper .fa.fa-random")
    private WebElement shuffleAllBtn;

    public PlaylistPage deletePlaylist(){
        deleteBtn.click();
        if (findElement(okBtn) != null){
            okBtn.click();
        }
        return this;
    }
    public PlaylistPage clickShuffleAll(){
        shuffleAllBtn.click();
        return this;
    }
}
