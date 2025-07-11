Feature:Issuing small business policy
  @TC_116_Issue_Submission_SBP
  @sbp
  @designated
  @smoke
  Scenario: TC_116_Issue_Submission_SBP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And  User Select Small Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And User adds Small Business coverages
    And User proceeds to quote the policy
    And User chooses to issue the policy
    Then User reviews the bound submission and confirms the policy transaction status