Feature: Return Commission to a Producer

  @TC_202_ReturnCommission
  Scenario: TC_202_ReturnCommission
    Given User launches the URL of GuideWire Billing Center
    When User enters valid credentials and logs into Billing Center
    And User selects a Producer for the Return Commission process
    And User navigates to the Return Commission option from the Actions tab
    And User fills in all necessary fields in the Return Commission screen
    And User completes the process by selecting Finish
    Then User verifies the details on the Summary screen
