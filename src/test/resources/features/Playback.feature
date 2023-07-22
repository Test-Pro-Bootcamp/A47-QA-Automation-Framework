Feature: Play/ Pause Features
  Background:
    Given I am logged in and my user avatar is displayed

  Scenario: Click Play Button Without Selecting a Song
    And I click the Play button located at the bottom of the screen
    When I hover over the Play button at the bottom of the screen, it should now display the Pause symbol

  Scenario: Play a Song from the All Songs Page
    And I click the All Songs button in the left tab
    And I right-click a song in the list 1
    Then I click the Playback button
    When I hover over the Play button at the bottom of the screen, it should now display the Pause symbol