Feature: Login feature

  Background:
    Given I open Login page

  Scenario: Login with Valid Credentials
    When I enter email "aimee.woodside@testpro.io"
    And I enter password "te$t$tudent13"
    And I click submit
    Then I am successfully logged into the website

  Scenario: Login with Invalid Credentials
    When I enter email "aimee@testpro.io"
    And I enter password "te$t$tudent13"
    And I click submit
    Then I am not logged into the website