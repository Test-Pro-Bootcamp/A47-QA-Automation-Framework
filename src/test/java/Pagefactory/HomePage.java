package Pagefactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlayList;

    @FindBy(css = "[name='name']")
    WebElement playListNameField;


    @FindBy(css = "div.success.show" )
    WebElement renamePlayListSuccessMsg;

    public HomePage(WebDriver givenDriver){
        super( givenDriver);
    }

    public HomePage doubleClickPlayList(){
        doubleClick(firstPlayList);
        return this;
    }
    public HomePage enterNewPlayListName(String playListName){
        findElement(playListNameField).sendKeys(playListName);
        findElement(playListNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playListNameField).sendKeys(playListName);
        findElement(playListNameField).sendKeys(Keys.ENTER);
        return this;


    }


    public String getRenamePlayListSuccessMsg(){
        return findElement(renamePlayListSuccessMsg).getText();
    }
}
