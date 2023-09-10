package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait = null;
    Actions actions = null;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    By overlayLocator = By.cssSelector(".overlay.loading");
    By successMsg = By.cssSelector("div.success.show");

    public void waitForOverlay(){ wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator)); }
    public WebElement getSuccessMsg(){ return findElement(successMsg); }
    public void click(By locator){ wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void doubleClick(By locator){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(e).perform();
    }
    public void contextClick(By locator){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(e).perform();
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement moveToElement(By locator){
        WebElement e = driver.findElement(locator);
        actions.moveToElement(e).perform();
        return e;
    }
}
