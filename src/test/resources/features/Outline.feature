Feature: Smoke Test Suite and Failing Features

# Consists of Smoke Test Scenarios and Scenarios that I need to Troubleshoot

  Scenario: Change Playlist Name From the Home Page using DoubleClick
    Given I am logged in and my user avatar is displayed
    When I double-click the playlist on row 3
    And I enter the new playlist name "Smoke Playlist"
    Then I should see a green success message in the top right corner of the home page

  Scenario: Playing Song from the Search Results Page
    Given I am logged in and my user avatar is displayed
    When I type into the searchbar the song title "birthday"
    And I click the View All button
    And I click the song on row 1
    And I click the Add To button
    And I add the song to the list in row 3
    And I click the Play button located at the bottom of the screen
    Then the song playing matches the song selected above