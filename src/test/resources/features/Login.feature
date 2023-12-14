Feature: login Feature

  Scenario: Login Success
    Given  I open Login Page
    When I enter email "andrea.guevara@testpro.io"
    And I enter password "te$t$udent"
    And I submit
    Then I am Logged in
