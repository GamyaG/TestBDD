Feature: Search Policy
@search_policy
Scenario: Seaching with policy from search claims
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    When the user searches for the policy in Search Claims
    Then the claim details are loaded successfully