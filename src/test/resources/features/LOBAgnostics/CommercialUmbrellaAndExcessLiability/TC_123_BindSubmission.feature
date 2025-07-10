Feature:Creating commercial umbrella bind
  @TC_123_Bind_Submission_CUP
  @cup
  @smoke
  Scenario: TC_123_Bind_Submission_CUP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User Select Commercial Umbrella Product Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And  User adds Commercial Umbrella Property coverages
    And User proceeds to quote the policy
    And User chooses to bind the policy
    Then User verifies the policy transaction status is Submission Bound