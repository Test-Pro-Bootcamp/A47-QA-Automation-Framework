package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePlaylistPage extends BasePage{

    public DeletePlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css ="a[href='#!/playlist/65494']" )
    WebElement accessPlaylist;

    @FindBy (css =".del" )
    WebElement  item;

    @FindBy (css ="button.ok" )
    WebElement  btn;

    public DeletePlaylistPage openPlaylist() {
        accessPlaylist.click();
        return this;
    }

    public DeletePlaylistPage deleteItem() {
        item.click();
        return this;
    }
    public DeletePlaylistPage deleteBtn() {
        btn.click();
        return this;
    }
}
