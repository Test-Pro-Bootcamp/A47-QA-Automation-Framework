package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver){

        super( givenDriver);
    }

    By firstPlayList = By.cssSelector(".playlist:nth-child(3)");
    By playListNameField = By.cssSelector("[name='name']");

    By renamePlayListSuccessMsg = By.cssSelector("div.success.show");

    public void doubleClickPlayList(){
        doubleClick(firstPlayList);
    }
    public void enterNewPlayListName(String playListName){
        findElement(playListNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playListNameField).sendKeys(playListName);
        findElement(playListNameField).sendKeys(Keys.ENTER);

    }
    public String getRenamePlayListSuccessMsg(){

        return findElement(renamePlayListSuccessMsg).getText();
    }
}
