Feature:Creating USA Personal Auto quote
  @TC_126_Quote_Submission_PAP
    @pap
  @smoke
  Scenario: TC_126_Quote_Submission_PAP
    Given User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User Select USA Personal Auto as Product
    And  User enters the mandatory fields in the Policy Info screen
    And User adds USA Personal Auto Standard Coverages
    And User enters driver and vehicle Details
    And User proceeds to quote the policy
    Then User verifies the policy transaction status is Submission