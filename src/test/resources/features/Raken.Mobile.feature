@ios @mobile @regression
Feature: Raken Mobile App - iOS

  Background:
    Given I launch the Raken iOS app

  @mobile-free-trial
  Scenario: Validate Start your free trial button
    When I click on the Start your free trial button
    Then I should be navigated to the free trial screen
    And I add the email address
    And I add the first name
    And I add the last name
    And I add the phone number
    And I add the company name
    And I click on next button
    Then I should be redirected to the confirm email screen



