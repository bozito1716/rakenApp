@demo-button @regression
Feature: Demo Button

  Background:
    Given I access the Raken website page
    When I click on the Demo button

  @validate-button
  Scenario: Validate the Demo Button
    Then I should be redirected to the request demo page

@validate-demo-button-redirect
  Scenario: Validate the Demo Button redirect
    Then I should be redirected to the request demo page
    And I Enter a real email address rakenqa@raken.com
    And I click on the next button
    And I Enter a real first name QA Raken
    And I Enter a real last name Automation
    And I Enter a unique company name
    And I select 11-50 from the dropdown options
    And I Enter a real phone number 1234567890

  @negative @regression
  Scenario: Validate error message when invalid email is entered
    And I Enter an invalid email address
    And I click on the next button
    Then I should see an error message for invalid email

