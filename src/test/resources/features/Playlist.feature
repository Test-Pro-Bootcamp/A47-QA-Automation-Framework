Feature: Playlist Features
  Background:
    Given I am logged in and my user avatar is displayed

  Scenario: Create a New Playlist From the Home Page
    When I click the Add Playlist button
    And I click the New Playlist button
    And I enter the new playlist name "HomePage Playlist"
    Then I should see a green success message in the top right corner of the home page

  Scenario: Create a New Playlist By Adding a Song to it
    When I type into the searchbar the song title "dark"
    And I click the View All button
    And I click the song on row 1
    And I click the Add To button
    And I add the song to a new playlist by entering the name "JumpMan Playlist"
    Then I should see a green success message in the top right corner of the new playlist page

  Scenario: Change Playlist Name From the Home Page using DoubleClick
    When I double-click the playlist on row 3
    And I enter the new playlist name "Renamed This Playlist"
    Then I should see a green success message in the top right corner of the home page

  Scenario: Delete Playlist from Playlist Page
    And I click a playlist in the left tab 3
    When I click the Delete Playlist button on the Playlist Page
    Then I should see a green success message in the top right corner of the home page

  Scenario: Delete Playlist from Home Page
    And I right-click a playlist in the left tab 4
    When I click the Delete Playlist button on the Home Page
    Then I should see a green success message in the top right corner of the home page
