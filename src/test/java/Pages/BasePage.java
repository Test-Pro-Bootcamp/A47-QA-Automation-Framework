package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    //the variables above are made protected, because protected access gives the
    // subclass a chance to use the helper method or variables, while preventing
    // a non-related class from trying to use it.
    private By overlayLocator = By.cssSelector(".overlay.loading");
    //use encapsulation of non-static and non-final fields.
    //If a variable is used only by other methods of that class, it should be declared as private.
    //make all the locators and WebElements private, because private keyword in java
    // allows most restrictive access to variables and methods and offer strongest form of Encapsulation.
    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
    public WebElement findElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement findElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement findElementPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForOverlayToVanish(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }
}
