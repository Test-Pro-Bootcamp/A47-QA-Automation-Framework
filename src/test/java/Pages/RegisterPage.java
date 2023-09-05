package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //private By registrationLinkLocator = By.cssSelector("[id = 'hel']");
    @FindBy(xpath = "//*[@id='app']/div/div/form/div[2]/a")
    private WebElement registrationLinkLocator;

    //private By registerBtnLocator = By.xpath("//input[@id='button']");
    @FindBy(xpath = "//input[@id='button']")
    private WebElement registerBtnLocator;

    // Registration Navigation
    //-------------------------
    public void registrationNavigate() {
        findElementClickable(registrationLinkLocator).click();
        System.out.println("Registration link is clicked");
    }
    public boolean registerBtnIsDisplayed(){
        return (registerBtnLocator).isDisplayed();
    }
}
