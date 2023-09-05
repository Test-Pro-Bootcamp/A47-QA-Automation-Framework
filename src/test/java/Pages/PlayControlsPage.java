package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PlayControlsPage extends BasePage{
    public PlayControlsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@title='Play or resume' and  @data-testid='play-btn']")
    private WebElement PlayControlBtn;

    @FindBy(xpath = "//*[@title = 'Play next song' and @data-testid='play-next-btn']")
    private WebElement playNextSongButton;

    @FindBy(xpath = "//progress[@class='plyr__progress--played']")
    private WebElement progressBarLocator;

    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement soundBarVisualizer;

    @FindBy(css = "span.pause")
    private WebElement pauseButton;

    public void hoverOverPlayControl() throws InterruptedException {
        waitForOverlayToVanish();
        Thread.sleep(1000);
        hoverAction(PlayControlBtn);
    }
    public WebElement isPlayHoveredOver(){
        return (PlayControlBtn);
    }

// Play a song
//-------------------------
    public void clickPlayNextSong() {
        waitForOverlayToVanish();
        findElementClickable(playNextSongButton).click();
    }
    public  void clickPlaySong() {
        findElementClickable(PlayControlBtn).click();
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
