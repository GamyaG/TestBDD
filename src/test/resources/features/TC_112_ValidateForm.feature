Feature: Validate Forms
  @TC_112_ValidateForm
  Scenario: TC_112_ValidateForm
    Given User launches the URL of GuideWire Policy Center cloud
    When User enters valid credentials and logs into Policy Center cloud
    And User Open account and initiates a new submission
    And User selects Homeowners Product
    And User enters the mandatory fields in the Policy Info screen
    And User adds coverages for GW Homeowners Lines
    And User proceeds to quote the policy
    And User proceeds to select forms
    Then User verifies the generated forms



