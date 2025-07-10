Feature:Creating home owners bind
  @TC_119_Bind_Submission_HOP
  @hop
  @smoke
  Scenario: TC_119_Bind_Submission_HOP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User selects Homeowners Product
    And  User enters the mandatory fields in the Policy Info screen
    And User adds homeowners coverages
    And User proceeds to quote the policy
    And User chooses to bind the policy
    Then User verifies the policy transaction status is Submission Bound