Feature: Search Recovery
  @304_searchRecovery
Scenario: Searching recovery in claim center
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    And  User creates a new FNOL and verifies that it has been added successfully
    And User searches with the claim number and verify
    And the user creates the recovery
    And the user searches for the recovery details with claim number
    Then the recovery details are loaded