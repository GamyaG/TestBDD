Feature:Issuing Go Commercial Insurance Policies
  @TC_113_issue_submission_GCP
  @designated
  @smoke
  Scenario: TC_113_issue_submission_GCP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And  User Select Go Commercial Property Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And  User adds Go Commercial Property coverages
    And  User adds Cpblanket
    And User proceeds next In Location
    And User proceeds to quote the policy
    And User chooses to issue the policy
    Then User reviews the bound submission and confirms the policy transaction status