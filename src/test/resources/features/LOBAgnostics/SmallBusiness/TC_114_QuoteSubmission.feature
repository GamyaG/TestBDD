Feature:Creating small business quote
  @TC_114_Quote_Submission_SBP
  @sbp
  @smoke
  Scenario: TC_114_Quote_Submission_SBP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And  User Select Small Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And User adds Small Business coverages
    And User proceeds to quote the policy
    Then User verifies the policy transaction status is Submission