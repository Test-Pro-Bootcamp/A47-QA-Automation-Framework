Feature: User Profile Features
  Background:
    Given I am logged in and my user avatar is displayed

  Scenario: Change Username
    And I click my username in the top right corner
    And I enter my current password "te$t$tudent"
    And I enter a new username "BruceLeRoy"
    When I click the Save button
    Then the username I entered should match the username displayed "BruceLeRoy"