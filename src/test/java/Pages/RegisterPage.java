package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By registrationLinkLocator = By.cssSelector("[id = 'hel']");
    private By registerBtnLocator = By.xpath("//input[@id='button']");
    // Registration Navigation
    //-------------------------
    public void registrationNavigate() {
        WebElement registrationLink = findElementClickable(registrationLinkLocator);
        registrationLink.click();
        System.out.println("Registration link is clicked");
    }
    public boolean registerBtnIsDisplayed(){
        WebElement registerBtnElement = findElementVisible
                (registerBtnLocator);
        return registerBtnElement.isDisplayed();
    }
}
