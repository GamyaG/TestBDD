Feature: View Claim Summary
  @303_ClaimSummary
  Scenario: Viewing the summary of a claim
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    When  User creates a new FNOL and verifies that it has been added successfully
    And User searches with the claim number
    Then the claim summary details are loaded
