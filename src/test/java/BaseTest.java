import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public static String url = "https://qa.koel.app/";

    @BeforeSuite
static void setupClas(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
@Parameters({"BaseURL"})
public void launchBrowser(String BaseURL){
        ChromeOptions options=new ChromeOptions();
        opetions.addArguments("--remote-allow-origins=*");

        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofseconds(10));

        url=BaseURL;
        driver.get(url);
        }


