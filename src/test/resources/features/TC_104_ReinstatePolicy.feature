Feature: Policy Reinstatement Process
  @TC_104_ReinstatePolicy
  @designated
  @smoke
  Scenario: TC_104_ReinstatePolicy
    Given User launches the URL of GuideWire Policy Center cloud
    When User enters valid credentials and logs into Policy Center cloud
    And User Open account and initiates a new submission
    And User Select Go Commercial Property Line of Business
    And User enters the mandatory fields in the Policy Info screen
    And User adds Go Commercial Property coverages
    And User adds Cpblanket
    And User proceeds next In Location
    And User proceeds to quote the policy
    And User chooses to issue the policy
    And the user reviews the bound submission and confirms the policy transaction status
    And User searches for the policy under the policy tab
    And User starts a new transaction for the policy
    And User performs cancel policy transaction
    And User performs Reinstate policy transaction
    Then User verify Reinstatement Bound
