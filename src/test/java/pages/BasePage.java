package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public static String url = null;
    public static Actions actions = null;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    By overlayLocator = By.cssSelector(".overlay.loading");

    public void waitForOverlayToGoAway() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void doubleClickPlaylist(By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }

    public void contextClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(contextElement).perform();
    }
}
