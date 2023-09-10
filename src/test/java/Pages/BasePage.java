package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(css = ".overlay.loading")
    private WebElement overlay;

    //use encapsulation of non-static and non-final fields.
    //If a variable is used only by other methods of that class, it should be declared as private.
    //make all the locators and WebElements private, because private keyword in java
    // allows most restrictive access to variables and methods and offer strong form of Encapsulation.
    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public void waitForOverlayToVanish () {
        wait.until(ExpectedConditions.invisibilityOf(overlay));
    }
    public  void waitForElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement findElementVisible (WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement findElementClickable (WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void contextClick (WebElement element){
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOf(element));
        actions.contextClick(contextElement).perform();
    }

//   public void doubleClick (By locator){
//        WebElement doubleClickElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        actions.doubleClick(doubleClickElement).perform();
//    }
    public void doubleClick (WebElement element) {
        actions.doubleClick(findElementVisible(element)).perform();
    }
    public void hoverAction (WebElement element){
        //      wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }
}
