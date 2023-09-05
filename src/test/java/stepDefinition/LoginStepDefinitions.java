package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginStepDefinitions {
        public static WebDriver driver = null;
        public static WebDriverWait wait = null;
        public static Actions actions = null;
        public static String url = null;

        By emailField = By.cssSelector("[type = 'email']");
        By passwordField = By.cssSelector("[type = 'password']");
        By submitButton = By.cssSelector("[type = 'submit']");
        By overlay = By.cssSelector(".overlay.loading");
        By userAvatarIcon = By.cssSelector("img.avatar");


        @Before
        public void setUpBrowser(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito",
                    "--start-maximized");
            driver = new ChromeDriver(chromeoptions);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @After
        public void closeBrowser() {
            driver.quit();
        }
        public WebElement findElementVisible(By locator){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        public WebElement findElementClickable(By locator){
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        @Given("I open Login page")
        public void openLoginPage(){
            driver.get("https://qa.koel.app");
        }
        @When("I enter email {string}")
        public void iEnterEmail(String email){
            findElementVisible(emailField).sendKeys(email);
        }
        @And("I enter password {string}")
        public void iEnterPassword(String password){
            findElementVisible(passwordField).sendKeys(password);
        }
        @And("I submit")
        public void iSubmit(){
            findElementClickable(submitButton).click();
        }
        @Then("I am logged into the website")
        public void userLoggedIn(){
            Assert.assertTrue(avatarIsDisplayed());
        }
        public void waitForOverlayToVanish () {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        }
        public boolean avatarIsDisplayed(){
            waitForOverlayToVanish ();
            return (findElementVisible(userAvatarIcon)).isDisplayed();
        }

        @Then("I am NOT logged into the website")
        public void userNOTLoggedIn() {
            url = "https://qa.koel.app/";
            Assert.assertEquals(driver.getCurrentUrl(), url);
        }
}


