package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions ;
    public  String url = "https://qa.koel.app/";
    public  BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }


     @FindBy(css="[.overlay.loading]")
    public WebElement overlayLocator;

    @FindBy(css = "div.success.show")
    public WebElement confirmationMessage;


    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public  void waitForOverlayElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String getConfirmationText(){
        waitForOverlayElement(confirmationMessage);
       return confirmationMessage.getText();
    }

    protected void contextClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(contextElement).perform();
    }
    protected void rightClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(contextElement).perform();
    }
    public  void waitForOverlay(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void doubleClick(WebElement element) {
        WebElement contextElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.doubleClick(contextElement).perform();
    }

    public void hoverAction(WebElement element) {
      wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }
    public void clickOn(WebElement element) {
        WebElement contextElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.click(contextElement).perform();

    }
}


