Feature: Return Quote Process
  @TC_106_ReturnQuote
  @smoke
  Scenario: TC_106_ReturnQuote
    Given User launches the URL of GuideWire Policy Center cloud
    When User enters valid credentials and logs into Policy Center cloud
    And User Open account and initiates a new submission
    And User Select Go Commercial Property Line of Business
    And User enters the mandatory fields in the Policy Info screen
    And User adds Go Commercial Property coverages
    And User adds Cpblanket
    And User proceeds next In Location
    And User proceeds to quote the policy
    And User selects the premium option and navigates back to the Quote section
    Then User verifies the policy transaction status is Submission
