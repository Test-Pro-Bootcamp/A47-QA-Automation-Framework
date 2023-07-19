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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }


     @FindBy(css="[.overlay.loading]")
    public WebElement overlayLocator;

    @FindBy(xpath = "[//div[@class='alertify-logs top right']")
    private WebElement confirmationMessage;


    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public String getConfirmationText(){

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
    public  void waitForOverlay(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void doubleClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(contextElement).perform();
    }

    public void hoverAction(By locator) {
      WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(contextElement).perform();
    }
}


