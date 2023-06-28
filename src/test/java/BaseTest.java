import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    String url = "https://qa.koel.app/";
    //Locators
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");
    By submitButton = By.cssSelector("[type = 'submit']");
    //By playNextSongButton = By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    By playNextSongButton = By.cssSelector("i.next.fa.fa-step-forward.control");
    //By playSongButton = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");
    By playSongButton = By.cssSelector("span.play i.fa.fa-play");

    //By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");
    By pauseButton = By.cssSelector("span.pause i.fa.fa-pause");

    //By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By soundBarVisualizer = By.cssSelector("div.bars");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
//    public void openLoginURL() {
//        driver.get(url);
//    }
//    public void provideEmail(String Email) {
//        WebElement emailFieldElement = driver.findElement(emailField);
//        emailFieldElement.sendKeys(Email);
//    }
//    public void providePW(String Password) {
//        WebElement passwordFieldElement = driver.findElement(passwordField);
//        passwordFieldElement.sendKeys(Password);
//    }
//    public void clickSubmit() {
//        WebElement submitButtonElement = driver.findElement(submitButton);
//        submitButtonElement.click();
//    }
    public void login(String Email, String Password){
        driver.get(url);
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(Email);
        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(Password);
        WebElement submitButtonElement = driver.findElement(submitButton);
        submitButtonElement.click();
    }
    public void clickPlayNextSong() throws InterruptedException{
        WebElement playNextSongElement = driver.findElement(playNextSongButton);
        playNextSongElement.click();
        System.out.println("Play Next Song Clicked");
        Thread.sleep(2000);
    }
   public void clickPlaySong() throws InterruptedException{
        WebElement PlaySongElement = driver.findElement(playSongButton);
        PlaySongElement.click();
        System.out.println("Play Song Clicked");
       Thread.sleep(2000);
    }
    public boolean pauseButtonDisplay() throws InterruptedException {
        WebElement pauseButtonElement = driver.findElement(pauseButton);
        Thread.sleep(2000);
        return pauseButtonElement.isDisplayed();
    }
    public boolean soundBarVisualizerDisplay() throws InterruptedException{
        WebElement soundBarVisualizerElement = driver.findElement(soundBarVisualizer);
        Thread.sleep(2000);
        return soundBarVisualizerElement.isDisplayed();
    }
}