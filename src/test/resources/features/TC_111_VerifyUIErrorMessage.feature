Feature: Homeowners Product Policy Submission
  @TC_111_VerifyErrorMessage
  Scenario: TC_111_VerifyErrorMessage
    Given User launches the URL of GuideWire Policy Center cloud
    When User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User selects Homeowners Product
    And User enters the mandatory fields in the Policy Info screen
    And User proceeds without completing the required information on the Homeowners screen
    Then User confirms that appropriate error messages are displayed on the coverages screen

