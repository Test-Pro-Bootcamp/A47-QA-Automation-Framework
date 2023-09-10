package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    private WebDriverWait wait = null;
    private Actions actions = null;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".overlay.loading")
    private WebElement overlayLocator;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;

    public BasePage waitForOverlay(){ wait.until(ExpectedConditions.invisibilityOf(overlayLocator)); return this;}
    protected void click(WebElement e){ wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }
    protected void doubleClick(WebElement e){ actions.doubleClick(wait.until(ExpectedConditions.elementToBeClickable(e))).perform(); }
    protected void contextClick(WebElement e){ actions.contextClick(wait.until(ExpectedConditions.elementToBeClickable(e))).perform(); }
    public WebElement getSuccessMsg(){ return findElement(successMsg); }
    public WebElement findElement(WebElement e){ actions.moveToElement(e).perform(); wait.until(ExpectedConditions.visibilityOf(e));
        return e;}
}
