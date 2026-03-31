@trial-banner @regression
Feature: Raken Website - Trial Banner

  Background:
    Given I access the Raken website banner page


  @unique-data
  Scenario: Validate successful validate banner

    When I Enter a unique first name
    And I Enter a unique last name
    And I Enter a unique phone number
    And I Enter a unique email address
    And I Enter a unique company name
    And I click on the Company Size dropdown
    And I select 11-50 from the dropdown options
    And I click on the Start Free Trial button
    And I am redirected to the Calendar page
    And I selected a date from the calendar
    And I selected a time from the time options
    Then I should see a confirmation message that my trial has been scheduled

    @real-data
    Scenario: Validate real data in the banner page
    When I Enter a real first name QA Raken
    And I Enter a real last name Automation
    And I Enter a real phone number 1234567890
    And I Enter a real email address rakenqa@raken.com
    And I Enter a real company name Raken
    And I click on the Company Size dropdown
    And I select 11-50 from the dropdown options
    And I click on the Start Free Trial button
    And I am redirected to the Calendar page
    And I selected a date from the calendar
    And I selected a time from the time options
    Then I should see a confirmation message that my trial has been scheduled





