@Rerun
Feature: Testing rerun Functionality
  Scenario:my contact form
    Given user navigates to my contact form
    When user enters valid credentials
    And user click on submit button
    And user click on logout button
    Then user quits the browser
    Scenario: youtube
      Given user navigates to youtube
      And user type something in search
      Then user quits the youtube
      Scenario: Amazon
        Given user navigates to Amazon
        When user search for a product
        Then user quits the amazon



