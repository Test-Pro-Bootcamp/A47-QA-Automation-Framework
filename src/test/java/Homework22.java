import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework22 extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("abdul.hasib.yousufzai@testpro.io", "test12345");
        PlaylistPage playlistPage = homePage.navigateToPlaylist();
        playlistPage.renamePlaylist("Favorite");
        driver.quit();
    }
}

class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email, String password) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();

        return new HomePage(driver);
    }
}

class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public PlaylistPage navigateToPlaylist() {
        WebElement playlistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        playlistElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar")));
        return new PlaylistPage(driver);
    }
}

class PlaylistPage {
    private WebDriver driver;

    public PlaylistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void renamePlaylist(String newName) {
        WebElement playlistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"sidebar\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(playlistElement)
                .doubleClick()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .sendKeys(newName).click(sideBar)
                .build()
                .perform();
    }
}
