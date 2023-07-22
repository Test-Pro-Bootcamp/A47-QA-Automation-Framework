Feature: Search Capability Features
  Background:
    Given I am logged in and my user avatar is displayed

  Scenario: Typing into the Searchbar in the Top Left Corner
    When I type into the searchbar the song title "birthday"
    Then I should see the search results and orange 'View All' button

  Scenario: Playing Song from the Search Results Page
    When I type into the searchbar the song title "birthday"
    And I click the View All button
    And I click the song on row 1
    And I click the Add To button
    And I add the song to the list in row 3
    And I click the Play button located at the bottom of the screen
    Then the song playing matches the song selected above