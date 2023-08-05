package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayControlsPage extends BasePage{
    public PlayControlsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //private By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement soundBarVisualizer;

    //private By pauseButton = By.cssSelector("span.pause");
    @FindBy(css = "span.pause")
    private WebElement pauseButton;
    // private By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");

    //play control - play button
    //private By PlayControlBtn = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");
    @FindBy(xpath = "//*[@title='Play or resume' and  @data-testid='play-btn']")
    private WebElement PlayControlBtn;

    //------------------------------
    // Locators: Play Song
    //private By playNextSongButton = By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    @FindBy(xpath = "//*[@title = 'Play next song' and @data-testid='play-next-btn']")
    private WebElement playNextSongButton;

   // private By progressBarLocator = By.xpath("//progress[@class='plyr__progress--played']");
    @FindBy(xpath = "//progress[@class='plyr__progress--played']")
    private WebElement progressBarLocator;

//    private By progressBar = By.xpath(“//input[@type ='range' and @class = 'plyr__progress--seek’]”);
//    XPath for Play Next Song: //*[@title = 'Play next song' and @data-testid='play-next-btn']
//    XPath for Play button: //*[@title='Play or resume' and  @data-testid='play-btn']
//    XPath for Pause button: //span[@title ='Pause' and @data-testid='pause-btn']
//    CSS Selector for Sound Bar: [data-testid="sound-bar-play"]

    public void hoverOverPlayControl() throws InterruptedException {
        waitForOverlayToVanish();
        Thread.sleep(1000);
        hoverAction(PlayControlBtn);
    }
    public WebElement isPlayHoveredOver(){
        return (PlayControlBtn);
    }

    //HW 18: Play a song
//-------------------------
    public void clickPlayNextSong() {
        waitForOverlayToVanish();
        playNextSongButton.click();
    }
    public  void clickPlaySong() {
         PlayControlBtn.click();
        //    Actions actions = new Actions(driver);
        //    actions.click(playSongElement).perform();
    }
    public boolean pauseButtonDisplay()  {
        boolean PauseDisplaySuccess = pauseButton.isDisplayed();
        System.out.println("Pause Button Displayed = " + PauseDisplaySuccess);
        return PauseDisplaySuccess;
    }
    public boolean soundBarVisualizerDisplay() {
        boolean soundBarVisualDisplaySuccess = soundBarVisualizer.isDisplayed();
        System.out.println("SoundBar Visualizer Displayed = " + soundBarVisualDisplaySuccess);
        return soundBarVisualDisplaySuccess;
    }
    public boolean progressBarDisplay(){
        boolean progressBarDisplaySuccess = progressBarLocator.isDisplayed();
        System.out.println("ProgressBar Displayed = " + progressBarDisplaySuccess);
        return progressBarDisplaySuccess;
    }
}
