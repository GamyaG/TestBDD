Feature:Issuing home owners policy
  @TC_124_Issue_Submission_CUP
  @cup
  @designated
  @smoke
  Scenario: TC_124_Issue_Submission_CUP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User Select Commercial Umbrella Product Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And  User adds Commercial Umbrella Property coverages
    And User proceeds to quote the policy
    And User chooses to issue the policy
    Then User reviews the bound submission and confirms the policy transaction status