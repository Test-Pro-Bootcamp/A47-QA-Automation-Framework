Feature: Login feature

  Background:
    Given I open Login page

  Scenario: Login Success
    When I enter email "teststudent@teststudent.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged into the website

  Scenario: Login Failure (unregistered email)
    When I enter email "nonexisting@email.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am NOT logged into the website

  Scenario: Login Failure (wrong password)
    When I enter email "teststudent@teststudent.com"
    And I enter password "teStStudent"
    And I submit
    Then I am NOT logged into the website

  Scenario: Login Failure (empty password)
    When I enter email "teststudent@teststudent.com"
    And I enter password ""
    And I submit
    Then I am NOT logged into the website

  Scenario: Login Failure (empty email and password)
    When I enter email ""
    And I enter password ""
    And I submit
    Then I am NOT logged into the website
