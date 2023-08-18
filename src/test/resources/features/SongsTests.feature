Feature: SongsTests
  Background:
    Given I am logged into a website

  Scenario: Play A Song
      When I click AllSongs menu
      And I double click first song
      Then Song is playing

  Scenario: Add a Song to Playlist
    When I click AllSongs menu
    And I click first song
    And I choose add too
    And I choose Playlist
    Then song was added to playlist