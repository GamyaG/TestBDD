Feature: Payment Plan Creation Process
  @TC_201_CreatePaymentPlan
  Scenario: TC_201_CreatePaymentPlan
    Given User launches the URL of GuideWire Billing Center
    When User enters valid credentials and logs into Billing Center
    And User initiates a new payment plan from the Actions tab
    And User enters required information in the initial setup fields
    And User proceeds to Step Two of the Payment Plan Wizard and completes the additional required fields
    And User finalizes the payment plan by clicking Finish
    Then User verifies that the new payment plan has been successfully created