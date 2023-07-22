package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PlayControlsPage extends BasePage{
    public PlayControlsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    private By pauseButton = By.cssSelector("span.pause");
    // private By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");

    //play control - play button
    private By PlayControlBtn = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");

    //------------------------------
    // Locators: Play Song
    private By playNextSongButton = By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    private By progressBarLocator = By.xpath("//progress[@class='plyr__progress--played']");

//    private By progressBar = By.xpath(“//input[@type ='range' and @class = 'plyr__progress--seek’]”);
//    XPath for Play Next Song: //*[@title = 'Play next song' and @data-testid='play-next-btn']
//    XPath for Play button: //*[@title='Play or resume' and  @data-testid='play-btn']
//    XPath for Pause button: //span[@title ='Pause' and @data-testid='pause-btn']
//    CSS Selector for Sound Bar: [data-testid="sound-bar-play"]
    public boolean isSongPlaying() {
        WebElement soundBarVisualizerBarElement = findElementPresence(soundBarVisualizer);
        return soundBarVisualizerBarElement.isDisplayed();
    }
    public void hoverOverPlayControl(){
        waitForOverlayToVanish();
        WebElement hoverOverPlayBtnElement = findElementPresence(PlayControlBtn);
        actions.moveToElement(hoverOverPlayBtnElement).perform();
        System.out.println("Hovered Over Play Control");
    }
    public WebElement isPlayHoveredOver(){
        WebElement PlayBtnElement = findElementVisible(PlayControlBtn);
        System.out.println("Play Control is visible");
        return PlayBtnElement;
    }
    //HW 18: Play a song
//-------------------------
    public void clickPlayNextSong() {
        waitForOverlayToVanish();
        WebElement playNextSongElement = findElementPresence(playNextSongButton);
        playNextSongElement.click();
        System.out.println("Play Next Song Button is clicked");
    }
    public  void clickPlaySong() {
        WebElement playSongElement = findElementPresence(PlayControlBtn);
        playSongElement.click();
        System.out.println("Play Song Button is clicked");
        //    Actions actions = new Actions(driver);
        //    actions.click(playSongElement).perform();
    }
    public boolean pauseButtonDisplay()  {
        WebElement pauseButtonElement = findElementPresence(pauseButton);
        boolean PauseDisplaySuccess = pauseButtonElement.isDisplayed();
        System.out.println("Pause Button Displayed = " + PauseDisplaySuccess);
        return PauseDisplaySuccess;
    }
    public boolean soundBarVisualizerDisplay() {
        WebElement soundBarVisualizerBarElement = findElementPresence(soundBarVisualizer);
        boolean soundBarVisualDisplaySuccess = soundBarVisualizerBarElement.isDisplayed();
        System.out.println("SoundBar Visualizer Displayed = " + soundBarVisualDisplaySuccess);
        return soundBarVisualDisplaySuccess;
    }
    public boolean progressBarDisplay(){
        WebElement progressBarElement = findElementVisible(progressBarLocator);
        boolean progressBarDisplaySuccess = progressBarElement.isDisplayed();
        System.out.println("ProgressBar Displayed = " + progressBarDisplaySuccess);
        return progressBarDisplaySuccess;
    }
}
