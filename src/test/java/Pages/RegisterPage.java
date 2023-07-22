package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Registration Navigation
    //-------------------------
    public void registrationNavigate() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("[id = 'hel']")));
        registrationLink.click();
        System.out.println("Registration link is clicked");
    }
    public boolean registerBtnIsDisplayed(){
        WebElement registerBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='button']")));
        return registerBtnElement.isDisplayed();
    }
}
