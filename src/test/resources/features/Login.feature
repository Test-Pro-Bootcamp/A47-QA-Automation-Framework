Feature: Login Feature
  Scenario: Successful user login
  Given I am in the Login Page
  When I enter email "daviyontae.floyd@testpro.io"
  And I enter password "te$t$tudent"
  And I click the submit button
  Then I am land on the Home Page and my user avatar is displayed