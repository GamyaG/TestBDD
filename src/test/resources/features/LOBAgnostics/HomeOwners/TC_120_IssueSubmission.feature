Feature:Issuing home owners policy
  @TC_120_Issue_Submission_HOP
  @hop
  @designated
  @smoke
  Scenario: TC_120_Issue_Submission_HOP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User selects Homeowners Product
    And  User enters the mandatory fields in the Policy Info screen
    And User adds homeowners coverages
    And User proceeds to quote the policy
    And User chooses to issue the policy
    Then User reviews the bound submission and confirms the policy transaction status