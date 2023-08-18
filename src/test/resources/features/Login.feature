Feature: Login feature
  Background:
    Given I open Login page

  Scenario: Login Success

    When I enter email "yuliyakis85@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged into a website

  Scenario: Login Incorrect Password
      When I enter email "yuliyakis85@gmail.com"
      And I enter password "incorrectPassword"
      And I submit
      Then I am not logged in

  Scenario: Login Not Existing Email
        When I enter email "notexistingemail.com"
        And I enter password "te$t$tudent"
        And I submit
        Then I am not logged in
    Scenario: Login With Empty Email Password
      When I enter email " "
      And I enter password " "
      And I submit
      Then I am not logged in

