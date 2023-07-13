package pages;


public SongsPage (WebDriver givenDriver) {

        super(givenDriver);


public void addSongToPlaylist(String email, String password) throws InterruptedException{
        String newSongAddedNotificationText = "Added 1 song into";
        //open url
        //openLoginUrl();
        //input email
        enterEmail(email);
        //input password
        enterPassword(password);
        //click submit
        clickSubmit();

        //search for song
        searchForSong("Dark Days");
        //click View All Btn
        clickViewAllBtn();
        // verify on search results page
        verifySearchUrl();
        //select the first song returned in the search
        selectFirstSongResult();
        //click Add To Btn
        clickAddToBtn();
        //choose Playlist to add the song to
        choosePlaylist();
        //checking for success message notification
        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));


        }

public void choosePlaylist() {
        WebElement testPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[15]")));
        testPlaylist.click();
        }

public void clickAddToBtn() throws InterruptedException {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addTo.click();
        }

public void selectFirstSongResult() throws InterruptedException{
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")));
        firstResult.click();
        }

public void clickViewAllBtn() {
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewAllBtn.click();

        }

public void verifySearchUrl()  {
        WebElement songResultsWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']")));
        Assert.assertTrue(songResultsWrapper.isDisplayed());
        }

public void searchForSong(String song) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);

        }

public String getNotificationText () {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));
        return notificationElement.getText();
        }
    }

