Feature: Login feature
  Scenario: Login Success
    Given I open Login page
    When I enter email "matt.pierce@testpro.io"
    And I enter password "te$t$tudent1"
    And I click Submit
    Then I am logged in
