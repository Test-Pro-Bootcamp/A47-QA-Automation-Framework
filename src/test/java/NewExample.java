import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class NewExample {
    WebDriver driver;
    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/lusinedilbaryan/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa.koel.app/");
    }}
//    void logoTest();
//    WebDriver logo = driver.findElement(By.cssSelector())
//}