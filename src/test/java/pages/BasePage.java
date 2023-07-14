package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;

import java.time.Duration;


public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "https://qa.koel.app/";
    public  BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


     @FindBy(css="[.overlay.loading]")
    WebElement overlayLocator;


    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void contextClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(contextElement).perform();
    }
    private void rightClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(contextElement).perform();
    }
    public void waitForOverlay() {
          wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }
    private void doubleClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(contextElement).perform();
    }

    public void hoverAction(By locator) {
      WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(contextElement).perform();
    }
}


