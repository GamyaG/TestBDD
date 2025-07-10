@ProgressiveInsurance
Feature: Auto Insurance Quote Application
@AutoInsurance
  Scenario: Obtain an auto insurance quote by entering personal and vehicle details
    Given the user is on the Progressive Insurance homepage
    When the user starts an auto insurance quote with valid details
    And the user provides personal, address, vehicle, and driver information
    And the user reviews and confirms the details
    Then the user should see the "Rates" screen with available insurance quotes
