package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;

import java.time.Duration;


public class BasePage {
    public  BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "https://qa.koel.app/";

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    private void rightClick(By locator) {
        return wait.until(ExpectedConditions.ElementIsClickable(locator));
        locator.contextClick();
    }
    private void waitForOverlay(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    private void doubleClick(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        locator.double.click();
    }
}


