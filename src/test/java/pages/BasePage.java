package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

public BasePage (WebDriver givenDriver){
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    actions = new Actions(driver);
    PageFactory.initElements(driver,this);
}
public WebElement findElement (WebElement webElement){
    return wait.until(ExpectedConditions.visibilityOf(webElement));
}
public void contextClick(WebElement webElement){
    WebElement contextElement = wait.until(ExpectedConditions.visibilityOf(webElement));
    actions.contextClick(contextElement).perform();
}
public void hoverAction(WebElement webElement){
    actions.moveToElement(findElement(webElement)).perform();
}

}

