package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected Actions actions = null;
    public  String url = "https://qa.koel.app/";
    public  BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


     @FindBy(css="[.overlay.loading]")
    private WebElement overlayLocator;

    @FindBy(xpath = "[//div[@class='alertify-logs top right']")
    protected WebElement confirmationMessage;


    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public String getChangesText() {
        return confirmationMessage.getText();


    }
    public String getNotificationText () {

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
    public BasePage waitForOverlay() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) overlayLocator));
        return this;
    }
    protected void doubleClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(contextElement).perform();
    }

    protected void hoverAction(By locator) {
      WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(contextElement).perform();
    }
}


