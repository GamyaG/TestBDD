Feature:  Policy Cancellation Process
  @TC_102_CancelPolicy
    @designated
  @smoke
  Scenario: TC_102_CancelPolicy
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
    And User selects the option to cancel the policy
    And User enters the mandatory fields on the Cancel Policy screen
    And User clicks on the Start Cancellation button and then selects Cancel Now
    Then User verifies the policy cancellation status



