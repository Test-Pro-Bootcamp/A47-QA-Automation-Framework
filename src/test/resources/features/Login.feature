Feature: Login Features
  Background:
    Given I am on the Login Page

  Scenario: Successful Login
  When I enter email "daviyontae.floyd@testpro.io"
  And I enter password "te$t$tudent"
  And I click the submit button
  Then I am logged in and my user avatar should be displayed

  Scenario: Unsuccessful Login - Invalid Email
  META-DATA: {"dataProvider":"InvalidLoginData", "dataProviderClass":"BaseStepDefinition.class"}
    When I enter email '${email}'
    And I enter password '${password}'
    And I click the submit button
    Then my login is rejected and I am still on the Login Page
